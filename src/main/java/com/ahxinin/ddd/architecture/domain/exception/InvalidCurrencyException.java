package com.ahxinin.ddd.architecture.domain.exception;

/**
 * @author : hexin
 * @description: 汇率异常
 * @date : 2022-01-06
 */
public class InvalidCurrencyException extends RuntimeException{

    private String code;

    private String message;

    public InvalidCurrencyException(String code, String message){
        super(message);
        this.code = code;
        this.message = message;
    }

    public InvalidCurrencyException(){

    }
}
