package com.github.ls.order.entity.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ls.order.entity.base.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
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
