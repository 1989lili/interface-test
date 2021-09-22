package com.tuling.test;

import com.tuling.test.annotation.Hello;
import java.lang.reflect.Method;
import lombok.extern.slf4j.Slf4j;

/**
 * 注解原理解析
 * @author xiongxy
 * @Date 2021/9/22 20:40
 *
 * 注意：需要设置一个虚拟机启动参数，用于捕获 JDK 动态代理类。
 * -Dsun.misc.ProxyGenerator.saveGeneratedFiles=true
 */
@Slf4j
public class Test {

    @Hello(value="hello ",name="every one")
    public static void main(String[] args) throws NoSuchMethodException{
        Class cls = Test.class;
        Method method = cls.getMethod("main", String[].class);
        Hello annotation = method.getAnnotation(Hello.class);
        log.info(annotation.value() + annotation.name());
    }
}
