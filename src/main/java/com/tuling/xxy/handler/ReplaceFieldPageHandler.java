package com.tuling.xxy.handler;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tuling.xxy.constant.ReplaceHandlerEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 处理分页中的字典替换
 */
@Component
public class ReplaceFieldPageHandler implements ReplaceFieldHandler {
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
        facotry.register(ReplaceHandlerEnum.PAGE.getCode(), this);
    }

    @Override
    public void replace(Object data) {
        List<?> records = ((Page<?>) data).getRecords();
        // 数据不为空则处理
        Optional.ofNullable(records).orElse(new ArrayList<>()).forEach(record ->{
            // 遍历数据，调用工厂replace方法替换
            facotry.replace(record);
        });
    }
}
