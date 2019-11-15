package com.github.ls.order.service;

import com.github.ls.common.entity.ResponseCode;
import com.github.ls.common.entity.ResponseData;
import com.github.ls.common.order.*;
import com.github.ls.order.dao.*;
import com.github.ls.order.entity.ApproveVO;
import com.github.ls.order.entity.SubmitOrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private ClAttachmentInfoDao clAttachmentInfoDao;

    @Autowired
    private ClBaseInfoDao clBaseInfoDao;

    @Autowired
    private ClCarInfoDao clCarInfoDao;

    @Autowired
    private ClContractInfoDao clContractInfoDao;

    @Autowired
    private ClRiskControlInfoDao clRiskControlInfoDao;

    @Autowired
    private ClUserInfoDao clUserInfoDao;

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

        @Valid @NotNull ClRiskControlInfo riskControlInfo = submitOrderVO.getRiskControlInfo();
        riskControlInfo.setLoadOrderNo(load_order_no);
        riskControlInfo.setBizOrderNo(biz_order_no);

        clRiskControlInfoDao.save(riskControlInfo);

        @Valid @NotNull ClUserInfo userInfo = submitOrderVO.getUserInfo();
        userInfo.setLoadOrderNo(load_order_no);
        userInfo.setBizOrderNo(biz_order_no);

        clUserInfoDao.save(userInfo);

        return new ResponseData(ResponseCode.SUCCESS);
    }

    public ResponseData approveOrder(ApproveVO vo) {
        return null;
    }
}
