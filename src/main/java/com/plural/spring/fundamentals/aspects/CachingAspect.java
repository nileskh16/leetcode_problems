package com.plural.spring.fundamentals.aspects;

import com.plural.spring.fundamentals.dao.PassengerDaoImpl;
import com.plural.spring.fundamentals.models.Passenger;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class CachingAspect {

    private final Logger logger = Logger.getLogger(CachingAspect.class);

    @Around("execution(* com.plural.spring.fundamentals.dao.PassengerDaoImpl.getPassenger(..))")
    public Object cachePassenger(ProceedingJoinPoint joinPoint) throws Throwable {
        Object [] args = joinPoint.getArgs();
        Object result = joinPoint.proceed();
        Integer passengerId = (Integer) args[0];
        if (!PassengerDaoImpl.getPassengerMap().containsKey(passengerId)) {
            PassengerDaoImpl.getPassengerMap().put(passengerId, (Passenger) result);
            logger.info("Adding a new result into the cache with id " + passengerId);
        }
        return result;
    }
}