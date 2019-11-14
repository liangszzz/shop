package com.github.ls.common.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseData implements Serializable {

    @JSONField(name = "app_id")
    private String appId;

    @JSONField(name = "code")
    private ResponseCode code;

    @JSONField(name = "msg")
    private String msg;

    @JSONField(name = "result")
    private ResponseResult result;
}
