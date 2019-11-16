package com.github.ls.common.entity;

public enum ResponseCode {

    SUCCESS(200, "success"),

    BIZ_EXCEPTION(400, "biz_exception"),

    DATA_STATUS_ERROR(501, "data_status_error"),

    SERVER_EXCEPTION(500, "server exception");


    private final int value;

    private final String msg;


    ResponseCode(int value, String msg) {
        this.value = value;
        this.msg = msg;
    }


    @Override
    public String toString() {
        return value+msg;
    }
}
