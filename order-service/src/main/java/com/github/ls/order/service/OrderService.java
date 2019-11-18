package com.github.ls.order.service;

import com.github.ls.common.entity.ResponseCode;
import com.github.ls.common.entity.ResponseData;
import com.github.ls.common.exceptions.DataNotFoundException;
import com.github.ls.common.order.*;
import com.github.ls.order.dao.*;
import com.github.ls.common.order.mq.AddAttachmentVO;
import com.github.ls.order.entity.ApproveVO;
import com.github.ls.order.entity.SubmitOrderVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class OrderService {

    private final ClAttachmentInfoDao clAttachmentInfoDao;

    private final ClBaseInfoDao clBaseInfoDao;

    private final ClCarInfoDao clCarInfoDao;

    private final ClContractInfoDao clContractInfoDao;

    private final ClRiskControlInfoDao clRiskControlInfoDao;

    private final ClUserInfoDao clUserInfoDao;

    private final OrderMqDao orderMqDao;

    public OrderService(ClAttachmentInfoDao clAttachmentInfoDao, ClBaseInfoDao clBaseInfoDao, ClCarInfoDao clCarInfoDao, ClContractInfoDao clContractInfoDao, ClRiskControlInfoDao clRiskControlInfoDao, ClUserInfoDao clUserInfoDao, OrderMqDao orderMqDao) {
        this.clAttachmentInfoDao = clAttachmentInfoDao;
        this.clBaseInfoDao = clBaseInfoDao;
        this.clCarInfoDao = clCarInfoDao;
        this.clContractInfoDao = clContractInfoDao;
        this.clRiskControlInfoDao = clRiskControlInfoDao;
        this.clUserInfoDao = clUserInfoDao;
        this.orderMqDao = orderMqDao;
    }

    @Transactional(rollbackOn = RuntimeException.class)
    public ResponseData submitOrder(SubmitOrderVO submitOrderVO) {
        String load_order_no = UUID.randomUUID().toString().replace("-", "");
        ClBaseInfo clBaseInfo = submitOrderVO.getClBaseInfo();
        String biz_order_no = clBaseInfo.getBizOrderNo();
        clBaseInfo.setLoadOrderNo(load_order_no);

        clBaseInfoDao.save(clBaseInfo);

        List<ClAttachmentInfo> attachmentInfos = submitOrderVO.getAttachmentInfos();
        attachmentInfos.forEach(e -> {
            e.setLoadOrderNo(load_order_no);
            e.setBizOrderNo(biz_order_no);
        });
        clAttachmentInfoDao.saveAll(attachmentInfos);

        @Valid @NotNull ClCarInfo clCarInfo = submitOrderVO.getClCarInfo();
        clCarInfo.setLoadOrderNo(load_order_no);
        clCarInfo.setBizOrderNo(biz_order_no);
        clCarInfoDao.save(clCarInfo);

        @Valid @NotNull List<ClContactInfo> contactInfos = submitOrderVO.getContactInfos();
        contactInfos.forEach(e -> {
            e.setLoadOrderNo(load_order_no);
            e.setBizOrderNo(biz_order_no);
        });
        clContractInfoDao.saveAll(contactInfos);

        ClRiskControlInfo riskControlInfo = submitOrderVO.getRiskControlInfo();
        riskControlInfo.setLoadOrderNo(load_order_no);
        riskControlInfo.setBizOrderNo(biz_order_no);
        clRiskControlInfoDao.save(riskControlInfo);

        ClUserInfo userInfo = submitOrderVO.getUserInfo();
        userInfo.setLoadOrderNo(load_order_no);
        userInfo.setBizOrderNo(biz_order_no);
        clUserInfoDao.save(userInfo);

        orderMqDao.attachmentUploadMq(new AddAttachmentVO(load_order_no,attachmentInfos));
        orderMqDao.contractCreateMq(load_order_no);
        return new ResponseData(ResponseCode.SUCCESS);
    }

    @Transactional(rollbackOn = RuntimeException.class)
    public ResponseData approveOrder(ApproveVO vo) {
        Optional<ClBaseInfo> optionalClBaseInfo = clBaseInfoDao.findByLoadOrderNo(vo.getOrder_no());
        ClBaseInfo baseInfo = optionalClBaseInfo.orElseThrow(DataNotFoundException::new);
        if (baseInfo.getOrderStatus() == null || baseInfo.getOrderStatus() != 19) {
            return new ResponseData(ResponseCode.DATA_STATUS_ERROR, "订单非待审核状态!");
        }
        baseInfo.setAuditDate(new Date());
        baseInfo.setAuditName(vo.getAudit_name());
        baseInfo.setOrderStatus(Integer.parseInt(vo.getOrder_status()));
        clBaseInfoDao.save(baseInfo);
        //TODO 调用MQ
        return new ResponseData(ResponseCode.SUCCESS);
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
        ResponseData data = orderMqDao.attachmentUploadMq(vo);
        log.info(data.toString());
        return new ResponseData(ResponseCode.SUCCESS);
    }
}
