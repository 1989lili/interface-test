package com.tuling.xxy.config;

import com.tuling.xxy.entity.DictionaryTest;
import com.tuling.xxy.service.DictionaryTestService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author xiongxy
 * @Date 2021/9/21 11:57
 */
@Slf4j
@Component
public class DictionaryCacheConfig implements CommandLineRunner {

    @Autowired
    DictionaryTestService dictionaryTestService;

    @Resource
    RedisTemplate redisTemplate;

    @Override
    public void run(String... args) throws Exception {
        log.info("init dictionary start");
        List<DictionaryTest> list = dictionaryTestService.list();
        Optional.ofNullable(list).orElse(new ArrayList<>()).forEach(d ->{
            log.info("config -- "+d.getDicGroup()+"_"+d.getDicValue());
            redisTemplate.boundValueOps(d.getDicGroup()+"_"+d.getDicValue()).set(d);
        });
        log.info("init dictionary end");
    }
}
