package com.tuling.xxy.handler;

import com.tuling.xxy.constant.ReplaceHandlerEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ReplaceFieldClassHandler implements ReplaceFieldHandler {
    /**
     * 工厂类
     */
    @Autowired
    private ReplaceFieldFactory facotry;

    /**
     * 注册Handler
     */
    @PostConstruct
    public void init() {
        facotry.register(ReplaceHandlerEnum.DEFAULT.getCode(), this);
    }

    @Override
    public void replace(Object data) {
        facotry.replace(data);
    }
}
