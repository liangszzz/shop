package com.github.ls.common.exceptions;

import lombok.Builder;

@Builder
public class BizException extends RuntimeException {

    private int biz_code;

    private String msg;

    public BizException(Integer biz_code, String msg) {
        if (biz_code == null)
            this.biz_code = 10000;
        else
            this.biz_code = biz_code;
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        return biz_code + "" + msg;
    }
}
