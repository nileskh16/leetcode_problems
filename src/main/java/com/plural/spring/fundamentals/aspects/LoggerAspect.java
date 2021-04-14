package com.plural.spring.fundamentals.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

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

    @AfterReturning("execution (public String com.plural.spring.fundamentals.models.Flight.getId())")
    public void afterReturnAdvice() {
        logger.info("Flight id is being retrieved");
    }

    @Pointcut("execution (* *.print(..))")
    public void allPrintMethods() {
    }

    @After("allPrintMethods()")
    public void logAllPrintMethods() {
        logger.info("The print methods have been invoked");
    }

    @Pointcut("within(com.plural.spring.fundamentals.models.Ticket)")
    public void allTicketMethods() {
    }

    @Around("allTicketMethods()")
    public Object logTicketMethods(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        String methodName = thisJoinPoint.getSignature().getName();
        logger.warn(methodName + " is being invoked...");
        Object result = thisJoinPoint.proceed();
        logger.warn(methodName + " returned result " + result);
        return result;
    }
}