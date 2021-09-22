package com.tuling.test.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解原理解析-测试用
 * @author xiongxy
 * @Date 2021/9/22 20:41
 */
@Target(value = {ElementType.METHOD,ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Hello {
    String name();

    String value();
}
