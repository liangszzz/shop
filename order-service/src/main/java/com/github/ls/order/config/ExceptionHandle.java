package com.github.ls.order.config;

import com.github.ls.common.entity.ResponseCode;
import com.github.ls.common.entity.ResponseData;
import com.github.ls.common.exceptions.BizException;
import com.github.ls.common.exceptions.DataNotFoundException;
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
    @ExceptionHandler({DataNotFoundException.class})
    public ResponseData DataNotFoundExceptionHandler(DataNotFoundException ex) {
        ResponseData data=new ResponseData();
        data.setCode(ResponseCode.BIZ_EXCEPTION);
        data.setMsg(ex.getMessage());
        return data;
    }

    @ResponseBody
    @ExceptionHandler({BizException.class})
    public ResponseData BizExceptionHandler(BizException ex) {
        ResponseData data=new ResponseData();
        data.setCode(ResponseCode.BIZ_EXCEPTION);
        data.setMsg(ex.getMessage());
        return data;
    }

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
    public ResponseData ExceptionHandler(Exception ex) {
        log.info("error", ex);
        ResponseData data=new ResponseData();
        data.setCode(ResponseCode.SERVER_EXCEPTION);
        return data;
    }
}
