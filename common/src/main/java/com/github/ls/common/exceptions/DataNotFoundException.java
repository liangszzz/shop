package com.github.ls.common.exceptions;

public class DataNotFoundException extends RuntimeException {

    @Override
    public String getMessage() {
        return "数据不存在";
    }
}
