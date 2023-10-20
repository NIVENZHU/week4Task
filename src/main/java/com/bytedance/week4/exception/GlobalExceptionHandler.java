package com.bytedance.week4.exception;

import com.bytedance.week4.common.ApiRestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理统一异常的handler
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    //处理系统异常并保存进日志
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handleException(Exception ex){
        log.error("DefaultException:",ex);
        return ApiRestResponse.error(bdExceptionEnum.SYSTEM_ERROR);
    }

    //处理系统异常并保存进日志
    @ExceptionHandler(bdException.class)
    @ResponseBody
    public Object handleOaException(bdException ex){
        log.error("bdException:",ex);
        return ApiRestResponse.error(ex.getCode(),ex.getMessage());
    }

    //截断参数验证产生的错误
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ApiRestResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        log.error("MethodArgumentNotValidException",e);
        return handleBindingResult(e.getBindingResult());
    }

    public ApiRestResponse handleBindingResult(BindingResult result){
        //把异常处理为对外暴露的提示
        List<String> list  = new ArrayList<>();
        if(result.hasErrors()){
            List<ObjectError> allErrors = result.getAllErrors();
            for(int i = 0;i<allErrors.size();i++){
                ObjectError objectError = allErrors.get(i);
                String msg = objectError.getDefaultMessage();
                list.add(msg);
            }
        }
        if(list.size()==0){
            return ApiRestResponse.error(bdExceptionEnum.REQUEST_PARAM_ERROR);
        }
        return ApiRestResponse.error(bdExceptionEnum.REQUEST_PARAM_ERROR.getCode(),list.toString());
    }
}
