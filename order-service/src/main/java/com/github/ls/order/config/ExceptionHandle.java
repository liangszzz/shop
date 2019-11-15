package com.github.ls.order.config;

import com.github.ls.common.entity.ResponseData;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ValidationException;

@Component
public class ExceptionHandle {


    @ExceptionHandler({ValidationException.class})
    public ResponseData WebExchangeBindExceptionHandler() {
        return new ResponseData();
    }
}
