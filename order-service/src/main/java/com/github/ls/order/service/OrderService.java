package com.github.ls.order.service;

import com.github.ls.common.entity.ResponseData;
import com.github.ls.order.dao.*;
import com.github.ls.order.entity.SubmitOrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public ResponseData submitOrder(SubmitOrderVO submitOrderVO) {


        return null;
    }
}
