package com.plural.spring.fundamentals.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class CountryCodeExceptionAspect {

    private final Logger logger = Logger.getLogger(CountryCodeExceptionAspect.class);

    @AfterThrowing(
            pointcut = "execution(* com.plural.spring.fundamentals.dao.PassengerDaoImpl.getPassenger(..))",
            throwing = "ex")
    public void logException(Exception ex) {
        logger.error(ex.getMessage());
    }
}