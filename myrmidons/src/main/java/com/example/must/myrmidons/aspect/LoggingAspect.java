package com.example.must.myrmidons.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @Before("execution(* com.example.must.myrmidons.controller..*(..))")
    public void log(JoinPoint joinPoint) {
        log.info("La méthode ", joinPoint.getSignature());
    }
}