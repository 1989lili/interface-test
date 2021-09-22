package com.tuling.xxy;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自定义注解字典操作启动类
 *
 * @Author Xiongxy
 * @Since 2021/9/11 15:56
 */
@Slf4j
@SpringBootApplication
@MapperScan("com.tuling.xxy.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
