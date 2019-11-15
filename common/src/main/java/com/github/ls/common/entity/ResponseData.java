package com.github.ls.common.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseData implements Serializable {

    @JsonProperty(value = "app_id")
    private String appId;

    @JsonProperty(value = "code")
    private ResponseCode code;

    @JsonProperty(value = "msg")
    private String msg;

    @JsonProperty(value = "result")
    private ResponseResult result;

    public ResponseData() {
    }

    public ResponseData(ResponseCode code) {
        this.code = code;
    }

}
