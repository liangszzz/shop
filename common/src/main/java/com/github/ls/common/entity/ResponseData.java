package com.github.ls.common.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ResponseData implements Serializable {

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
