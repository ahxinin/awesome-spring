package com.ahxinin.aop;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author : hexin
 * @description: 日志切面
 * @date : 2022-06-04
 */
@Slf4j
@Aspect
@Component
public class PerformanceAspect {

    @Around("execution(* com.ahxinin..*(..))")
    public Object logPerformance(ProceedingJoinPoint point) throws Throwable {
        StopWatch watch = StopWatch.create();
        String name = point.getSignature().toShortString();
        try {
            return point.proceed();
        }finally {
            watch.stop();
            log.info("name:{} cost:{}ms", name, watch.getTime());
        }
    }
}
