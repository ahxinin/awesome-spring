package com.ahxinin.ddd.architecture.infrastructure.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author : hexin
 * @description: 返回值处理
 * @date : 2022-02-01
 */
@Aspect
@Component
public class ResultAspect {

    @Around("@annotation(ResultHandler)")
    public Object handel(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
        }catch (Exception e){
            return null;
        }
        return proceed;
    }
}