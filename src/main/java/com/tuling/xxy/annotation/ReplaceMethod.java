package com.tuling.xxy.annotation;

import java.lang.annotation.*;

/**
 * 方法注解
 * @author xiongxy
 * @since 2021-09-11
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ReplaceMethod {
}
