package com.github.ls.common.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Response implements Serializable {

    private String data;

    private String sign;

}
