package com.centralized.logging.aop.configuration;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.centralized.logging.aop.controller.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Entering " + className + "." + methodName);
    }

    @After("execution(* com.centralized.logging.aop.controller.*.*(..))")
    public void logMethodExit(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getName();
        String methodName= joinPoint.getSignature().getName();
        System.out.println("Exiting " + className + "." + methodName);
    }
}
