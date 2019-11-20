package com.github.ls.order.config;

import com.github.ls.common.entity.ResponseCode;
import com.github.ls.common.entity.ResponseData;
import com.github.ls.common.exceptions.BizException;
import com.github.ls.common.exceptions.DataNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.WebExchangeBindException;

@Slf4j
@ControllerAdvice
public class ExceptionHandle {

    @ResponseBody
    @ExceptionHandler({DataNotFoundException.class})
    public ResponseData DataNotFoundExceptionHandler(DataNotFoundException ex) {
        return ResponseData.builder().code(ResponseCode.BIZ_EXCEPTION).msg(ex.getMessage()).build();
    }

    @ResponseBody
    @ExceptionHandler({BizException.class})
    public ResponseData BizExceptionHandler(BizException ex) {
        return ResponseData.builder().code(ResponseCode.BIZ_EXCEPTION).msg(ex.getMessage()).build();
    }

    @ResponseBody
    @ExceptionHandler({WebExchangeBindException.class})
    public ResponseData WebExchangeBindExceptionHandler(WebExchangeBindException ex) {
        return ResponseData.builder().code(ResponseCode.SERVER_EXCEPTION).msg(ex.getMessage()).build();
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseData ExceptionHandler(Exception ex) {
        log.info("error", ex);
        return ResponseData.builder().code(ResponseCode.SERVER_EXCEPTION).msg(ex.getMessage()).build();
    }
}
