package com.centralized.logging.aop.configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before("execution(* com.centralized.logging.aop.controller.*.*(..)) || execution(* com.centralized.logging.aop.service.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Entering " + className + "." + methodName);
        log.info("Entering {}.{}", className, methodName);
    }

    @After("execution(* com.centralized.logging.aop.controller.*.*(..)) || execution(* com.centralized.logging.aop.service.*.*(..))")
    public void logMethodExit(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getName();
        String methodName= joinPoint.getSignature().getName();
        System.out.println("Exiting " + className + "." + methodName);
        log.info("Exiting {}.{}", className, methodName);
    }
}
