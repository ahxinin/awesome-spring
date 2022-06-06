package com.ahxinin.exception;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author : hexin
 * @description: 异常处理
 * @date : 2022-06-04
 */
@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,String> exceptionHandler(Exception exception){
        Map<String,String> map = new HashMap<>();
        map.put("message", exception.getMessage());
        return map;
    }

}
