package com.github.ls.common.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class Request implements Serializable {

    @NotBlank
    @JSONField(name = "app_id")
    private String appId;

    @NotBlank
    @JSONField(name = "data")
    private String data;

    @NotBlank
    @JSONField(name = "sign")
    private String sign;

    @Size(min = 10, max = 10)
    @JSONField(name = "timestamp")
    private String timestamp;

    @JSONField(name = "return_url")
    private String returnUrl;


}
