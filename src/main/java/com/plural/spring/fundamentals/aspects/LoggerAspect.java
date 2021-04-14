package com.plural.spring.fundamentals.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggerAspect {

    private final Logger logger = Logger.getLogger(LoggerAspect.class.getName());

//    @Before("execution (* *.*Passenger(..))")
//    public void beforeAdvice() {
//        logger.info("The passenger method is being invoked");
//    }
//
//    @After("execution (* *.*Passenger(..))")
//    public void afterAdvice() {
//        logger.info("The passenger method has been invoked");
//    }

    @Around("execution (* *.*Passenger(..))")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName = proceedingJoinPoint.getSignature().getName();
        logger.info(methodName + " is being executed...");
        Object result = proceedingJoinPoint.proceed();
        logger.info(methodName + " has been executed...");
        return result;
    }
}