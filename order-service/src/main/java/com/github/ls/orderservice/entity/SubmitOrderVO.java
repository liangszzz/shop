package com.github.ls.orderservice.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.ls.common.order.*;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class SubmitOrderVO {

    @Valid
    @NotNull
    @JSONField(name = "attachment_info")
    private List<ClAttachmentInfo> attachmentInfos;

    @Valid
    @NotNull
    @JSONField(name = "base_info")
    private ClBaseInfo clBaseInfo;

    @Valid
    @NotNull
    @JSONField(name = "car_info")
    private ClCarInfo clCarInfo;

    @Valid
    @NotNull
    @JSONField(name = "contract_info")
    private List<ClContactInfo> contactInfos;

    @Valid
    @NotNull
    @JSONField(name = "risk_info")
    private ClRiskControlInfo riskControlInfo;

    @Valid
    @NotNull
    @JSONField(name = "user_info")
    private ClUserInfo userInfo;
}
