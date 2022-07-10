package com.niu.datasource.config;

import com.niu.datasource.enums.DynamicDataSource;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface DbSelector {

    DynamicDataSource value() default DynamicDataSource.MASTER;
}
