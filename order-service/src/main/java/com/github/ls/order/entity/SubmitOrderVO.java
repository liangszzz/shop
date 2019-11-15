package com.github.ls.order.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ls.common.order.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class SubmitOrderVO implements Serializable {

    @Valid
    @NotNull
    @JsonProperty(value = "attachment_info")
    private List<ClAttachmentInfo> attachmentInfos;

    @Valid
    @NotNull
    @JsonProperty(value = "base_info")
    private ClBaseInfo clBaseInfo;

    @Valid
    @NotNull
    @JsonProperty(value = "car_info")
    private ClCarInfo clCarInfo;

    @Valid
    @NotNull
    @JsonProperty(value = "contract_info")
    private List<ClContactInfo> contactInfos;

    @Valid
    @NotNull
    @JsonProperty(value = "risk_control_info")
    private ClRiskControlInfo riskControlInfo;

    @Valid
    @NotNull
    @JsonProperty(value = "user_info")
    private ClUserInfo userInfo;
}
