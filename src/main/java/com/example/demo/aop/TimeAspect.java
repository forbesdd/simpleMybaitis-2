package com.example.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class TimeAspect {

    @Around("execution(* com.example.demo.service.*.*(..))")

    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {

        Long begin = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        Long end = System.currentTimeMillis();

        log.info(joinPoint.getSignature()+"実行時間：{}ms",end - begin);

        return result;
    }
}
