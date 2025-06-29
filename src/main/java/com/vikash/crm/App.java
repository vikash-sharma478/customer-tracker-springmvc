package com.vikash.crm.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import java.util.logging.Logger;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * LoggingAspect - Logs method calls in controller, service, and DAO layers.
 * Author: Vikash Kumar
 */
@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.vikash.crm.controller.*.*(..))")
    private void forControllerPackage() {}

    @Pointcut("execution(* com.vikash.crm.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* com.vikash.crm.dao.*.*(..))")
    private void forDAOPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
    private void forAppFlow() {}

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        logger.info("==> [BEFORE] Method: " + joinPoint.getSignature().toShortString());
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            logger.info("==> [ARG] " + arg);
        }
    }

    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        logger.info("==> [AFTER] Method: " + joinPoint.getSignature().toShortString());
        logger.info("==> [RESULT] " + result);
    }
}
