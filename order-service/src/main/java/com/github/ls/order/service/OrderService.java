package com.github.ls.order.service;

import com.github.ls.common.entity.ResponseCode;
import com.github.ls.common.entity.ResponseData;
import com.github.ls.common.exceptions.BizException;
import com.github.ls.common.exceptions.DataNotFoundException;
import com.github.ls.common.mq.OrderRollBackOutput;
import com.github.ls.order.entity.vo.AddAttachmentVO;
import com.github.ls.order.dao.*;
import com.github.ls.order.entity.vo.ApproveVO;
import com.github.ls.order.entity.vo.SubmitOrderVO;
import com.github.ls.order.entity.base.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@EnableBinding(OrderRollBackOutput.class)
public class OrderService {

    private final ClAttachmentInfoDao clAttachmentInfoDao;

    private final ClBaseInfoDao clBaseInfoDao;

    private final ClCarInfoDao clCarInfoDao;

    private final ClContractInfoDao clContractInfoDao;

    private final ClRiskControlInfoDao clRiskControlInfoDao;

    private final ClUserInfoDao clUserInfoDao;

    private final CouponDao couponDao;

    private final OrderRollBackOutput orderRollBackOutput;

    public OrderService(ClAttachmentInfoDao clAttachmentInfoDao, ClBaseInfoDao clBaseInfoDao, ClCarInfoDao clCarInfoDao,
                        ClContractInfoDao clContractInfoDao, ClRiskControlInfoDao clRiskControlInfoDao,
                        ClUserInfoDao clUserInfoDao, CouponDao couponDao, OrderRollBackOutput orderRollBackOutput) {
        this.clAttachmentInfoDao = clAttachmentInfoDao;
        this.clBaseInfoDao = clBaseInfoDao;
        this.clCarInfoDao = clCarInfoDao;
        this.clContractInfoDao = clContractInfoDao;
        this.clRiskControlInfoDao = clRiskControlInfoDao;
        this.clUserInfoDao = clUserInfoDao;
        this.couponDao = couponDao;
        this.orderRollBackOutput = orderRollBackOutput;
    }

    @Transactional(rollbackOn = RuntimeException.class)
    public ResponseData submitOrder(SubmitOrderVO submitOrderVO) {
        String load_order_no = UUID.randomUUID().toString().replace("-", "");

        ClBaseInfo clBaseInfo = submitOrderVO.getClBaseInfo();
        String biz_order_no = clBaseInfo.getBizOrderNo();
        clBaseInfo.setLoadOrderNo(load_order_no);
        clBaseInfo.setOrderStatus(19);

        List<ClAttachmentInfo> attachmentInfos = submitOrderVO.getAttachmentInfos();
        attachmentInfos.forEach(e -> {
            e.setLoadOrderNo(load_order_no);
            e.setBizOrderNo(biz_order_no);
        });

        ClCarInfo clCarInfo = submitOrderVO.getClCarInfo();
        clCarInfo.setLoadOrderNo(load_order_no);
        clCarInfo.setBizOrderNo(biz_order_no);

        List<ClContactInfo> contactInfos = submitOrderVO.getContactInfos();
        contactInfos.forEach(e -> {
            e.setLoadOrderNo(load_order_no);
            e.setBizOrderNo(biz_order_no);
        });

        ClRiskControlInfo riskControlInfo = submitOrderVO.getRiskControlInfo();
        riskControlInfo.setLoadOrderNo(load_order_no);
        riskControlInfo.setBizOrderNo(biz_order_no);

        ClUserInfo userInfo = submitOrderVO.getUserInfo();
        userInfo.setLoadOrderNo(load_order_no);
        userInfo.setBizOrderNo(biz_order_no);

        ResponseData coupon = couponDao.use(load_order_no, biz_order_no);
        if (coupon.getCode() != ResponseCode.SUCCESS) {
            return ResponseData.builder().code(ResponseCode.BIZ_EXCEPTION).msg("优惠券使用失败").build();
        }

        clBaseInfoDao.save(clBaseInfo);
        clCarInfoDao.save(clCarInfo);
        clAttachmentInfoDao.saveAll(attachmentInfos);
        clContractInfoDao.saveAll(contactInfos);
        clRiskControlInfoDao.save(riskControlInfo);
        clUserInfoDao.save(userInfo);
        return ResponseData.builder().code(ResponseCode.SUCCESS).build();
    }

    public void rollBackOrder(String load_order_no) {
        boolean send = orderRollBackOutput.output().send(MessageBuilder.withPayload(load_order_no).build());
        log.info(send + "");
    }

    @Transactional(rollbackOn = RuntimeException.class)
    public ResponseData approveOrder(ApproveVO vo) {
        Optional<ClBaseInfo> optionalClBaseInfo = clBaseInfoDao.findByLoadOrderNo(vo.getOrder_no());
        ClBaseInfo baseInfo = optionalClBaseInfo.orElseThrow(DataNotFoundException::new);
        if (baseInfo.getOrderStatus() == null || baseInfo.getOrderStatus() != 19) {
            return ResponseData.builder().code(ResponseCode.DATA_STATUS_ERROR).msg("订单非待审核状态!").build();
        }
        baseInfo.setAuditDate(new Date());
        baseInfo.setAuditName(vo.getAudit_name());
        baseInfo.setOrderStatus(Integer.parseInt(vo.getOrder_status()));
        clBaseInfoDao.save(baseInfo);
        //TODO 调用MQ
        return ResponseData.builder().code(ResponseCode.SUCCESS).build();
    }

    @Transactional(rollbackOn = RuntimeException.class)
    public ResponseData addAttachment(AddAttachmentVO vo) {
        Optional<ClBaseInfo> optionalClBaseInfo = clBaseInfoDao.findByLoadOrderNo(vo.getOrder_no());
        ClBaseInfo baseInfo = optionalClBaseInfo.orElseThrow(DataNotFoundException::new);
        vo.getList().forEach(e -> {
            e.setLoadOrderNo(baseInfo.getLoadOrderNo());
            e.setBizOrderNo(baseInfo.getBizOrderNo());
        });
        clAttachmentInfoDao.saveAll(vo.getList());
        return ResponseData.builder().code(ResponseCode.SUCCESS).build();
    }
}
