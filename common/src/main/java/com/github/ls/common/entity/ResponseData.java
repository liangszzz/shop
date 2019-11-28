package com.github.ls.common.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ResponseData implements Serializable {

    @Builder
    public ResponseData(String appId, ResponseCode code, String msg, ResponseResult result) {
        this.appId = appId;
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    @JsonProperty(value = "app_id")
    private String appId;

    @JsonSerialize
    @JsonProperty(value = "code")
    private ResponseCode code;

    @JsonProperty(value = "msg")
    private String msg;

    @JsonProperty(value = "result")
    private ResponseResult result;

}
