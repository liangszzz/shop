package com.github.ls.common.entity;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class ResponseResult extends JSONObject implements Serializable {

    @Override
    public String toString() {
        return toJSONString();
    }
}
