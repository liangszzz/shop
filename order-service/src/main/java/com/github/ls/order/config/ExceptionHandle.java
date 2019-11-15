package com.github.ls.order.config;

import com.github.ls.common.entity.ResponseCode;
import com.github.ls.common.entity.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.WebExchangeBindException;

@Slf4j
@ControllerAdvice
public class ExceptionHandle {


    @ResponseBody
    @ExceptionHandler({WebExchangeBindException.class})
    public ResponseData WebExchangeBindExceptionHandler(WebExchangeBindException ex) {
        ResponseData data=new ResponseData();
        data.setCode(ResponseCode.SERVER_EXCEPTION);
        data.setMsg(ex.getMessage());
        return data;
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseData noAuthExceptionHandler(Exception ex) {
        log.info("error", ex);
        ResponseData data=new ResponseData();
        data.setCode(ResponseCode.SERVER_EXCEPTION);
        return data;
    }
}
