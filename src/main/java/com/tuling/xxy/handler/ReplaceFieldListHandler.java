package com.tuling.xxy.handler;

import com.tuling.xxy.constant.ReplaceHandlerEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ReplaceFieldListHandler implements ReplaceFieldHandler {
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
        facotry.register(ReplaceHandlerEnum.LIST.getCode(), this);
        facotry.register(ReplaceHandlerEnum.ARRAYLIST.getCode(), this);
    }

    @Override
    public void replace(Object data) {
        List<?> records = (List) data;
        // 数据不为空则处理
        Optional.ofNullable(records).orElse(new ArrayList<>()).forEach( record ->{
            // 遍历数据，调用工厂replace方法替换
            facotry.replace(record);
        });
    }
}
