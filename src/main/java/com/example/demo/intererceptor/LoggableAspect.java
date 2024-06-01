package com.example.demo.intererceptor;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class LoggableAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggableAspect.class);

    @Around("@annotation(com.example.demo.intererceptor.Loggable)")
    public Object loggable(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        Loggable loggable = method.getAnnotation(Loggable.class);
        String value = loggable.value();
        LOGGER.info("Entering method: {}, with value: {}", method.getName(), value);

        Object result = joinPoint.proceed();

        LOGGER.info("Exiting method: {}, with result: {}", method.getName(), result);
        return result;
    }
}
