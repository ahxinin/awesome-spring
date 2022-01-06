package com.ahxinin.ddd.architecture.domain.exception;

/**
 * @author : hexin
 * @description: 余额不足
 * @date : 2022-01-06
 */
public class InsufficientBalanceException extends RuntimeException{

    private String code;

    private String message;

    public InsufficientBalanceException(String code, String message){
        super(message);
        this.code = code;
        this.message = message;
    }

    public InsufficientBalanceException(){

    }
}
