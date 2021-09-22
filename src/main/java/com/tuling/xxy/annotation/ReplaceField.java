package com.tuling.xxy.annotation;

import com.tuling.xxy.constant.ReplaceFieldType;

import java.lang.annotation.*;
/**
 * 属性注解
 * @author xiongxy
 * @since 2021-09-11
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ReplaceField {
    String name() default "";
    String type() default ReplaceFieldType.FIELD;
}
