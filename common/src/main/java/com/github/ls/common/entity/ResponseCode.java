package com.github.ls.common.entity;

public enum ResponseCode {

    SUCCESS(200, "SUCCESS"),

    SERVER_EXCEPTION(500, "server exception");


    private final int value;

    private final String msg;


    ResponseCode(int value, String msg) {
        this.value = value;
        this.msg = msg;
    }
}
