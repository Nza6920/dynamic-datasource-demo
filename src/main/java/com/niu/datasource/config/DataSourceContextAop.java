package com.niu.datasource.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Aspect
@Order(0)
@Component
public class DataSourceContextAop {

    @Around("@annotation(com.niu.datasource.config.DbSelector)")
    public Object setDynamicDataSource(ProceedingJoinPoint pjp) throws Throwable {
        try {
            Method method = this.getMethod(pjp);
            DbSelector annotation = method.getAnnotation(DbSelector.class);
            DataSourceContextHolder.set(annotation.value().getName());
            log.debug("数据源切换至：{}", annotation.value().getName());
            return pjp.proceed();
        } finally {
            DataSourceContextHolder.clear();
        }
    }

    private Method getMethod(JoinPoint pjp) {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        return signature.getMethod();
    }
}
