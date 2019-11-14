package com.github.ls.common.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Response implements Serializable {

    private String data;

    private String sign;

}
