package com.github.theinfinity007.springhibernatebootcourse.restcrud.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.hibernate.mapping.Join;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    // setup logger
    private Logger logger = Logger.getLogger(getClass().getName());

    // Setup pointcut declarations
    @Pointcut("execution(* com.github.theinfinity007.springhibernatebootcourse.restcrud.controllermvc.*.*(..))")
    private void forControllerMVCPackage() {
    }

    // For service
    @Pointcut("execution(* com.github.theinfinity007.springhibernatebootcourse.restcrud.service.*.*(..))")
    private void forServicePackage() {
    }

    // For service
    @Pointcut("execution(* com.github.theinfinity007.springhibernatebootcourse.restcrud.dao.*.*(..))")
    private void forDaoPackage() {
    }

    @Pointcut("forControllerMVCPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow(){}

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){
        // Display the method being called
        String method = joinPoint.getSignature().toShortString();
        logger.info("===========> in @Before: calling method: " + method);

        // display the args
        Object[] args = joinPoint.getArgs();

        for(Object arg: args){
            logger.info("===========> in @Before: arguments: " + arg);
        }
    }

}
