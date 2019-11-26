package com.github.ls.common.exceptions;

import com.github.ls.common.entity.ResponseCode;
import com.github.ls.common.entity.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.WebExchangeBindException;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@ControllerAdvice
public class ExceptionHandle {

    @ResponseBody
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseData dataIntegrityViolationExceptionHandler(DataIntegrityViolationException e) {
        return ResponseData.builder().code(ResponseCode.BIZ_EXCEPTION).msg(e.getMessage()).build();
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseData methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
        log.info(exception.getMessage());
        BindingResult result = exception.getBindingResult();
        final List<FieldError> fieldErrors = result.getFieldErrors();
        List<String> errorMsg = new ArrayList<>();

        for (FieldError error : fieldErrors) {
            errorMsg.add(error.getDefaultMessage());
        }

        return ResponseData.builder().code(ResponseCode.BIZ_EXCEPTION).msg(errorMsg.toString()).build();
    }

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
