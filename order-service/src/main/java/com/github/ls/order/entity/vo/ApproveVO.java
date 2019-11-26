package com.github.ls.order.entity.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
@Builder
public class ApproveVO implements Serializable {

    @NotBlank
    @JsonProperty(value = "order_no")
    private String order_no;

    @Pattern(regexp = "60|22")
    @JsonProperty(value = "order_status")
    private String order_status;

    @JsonProperty(value = "audit_name")
    private String audit_name;

    @JsonProperty(value = "msg")
    private String msg;

}
