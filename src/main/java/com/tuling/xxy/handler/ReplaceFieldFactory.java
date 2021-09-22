package com.tuling.xxy.handler;

import com.tuling.xxy.annotation.ReplaceField;
import com.tuling.xxy.constant.ReplaceFieldConstant;
import com.tuling.xxy.constant.ReplaceFieldType;
import com.tuling.xxy.entity.DictionaryTest;
import com.tuling.xxy.service.DictionaryTestService;
import com.tuling.xxy.util.CodeStringUtil;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReplaceFieldFactory {

    @Autowired
    DictionaryTestService dictionaryTestService;

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * map，存放handler
     */
    private Map<String, ReplaceFieldHandler> handlerMap = new HashMap<>();

    /**
     * 注册handler
     *
     * @param key     handler key
     * @param handler handler
     */
    public void register(String key, ReplaceFieldHandler handler) {
        if (handlerMap.containsKey(key)) {
            log.error("handler is already exists!");
            return;
        }
        handlerMap.put(key, handler);
    }

    /**
     * 获取handler
     *
     * @param key key
     * @return handler
     */
    public ReplaceFieldHandler get(String key) {
        return handlerMap.getOrDefault(key, null);
    }

    /**
     * 替换数据的值
     *
     * @param obj 要替换的对象
     */
    public void replace(Object obj) {
        Class<?> objClass = obj.getClass();
        Field[] declaredFields = objClass.getDeclaredFields();
        for (Field field : declaredFields) {
            ReplaceField annotation = field.getAnnotation(ReplaceField.class);
            if (annotation != null) {
                String type = annotation.type();
                String name =
                    StringUtils.isNotEmpty(annotation.name()) ? annotation.name() : field.getName();
                if (ReplaceFieldType.FIELD.equals(type)) {
                    field.setAccessible(true);
                    try {
                        Object fieldObj = field.get(obj);
                        if (null != fieldObj) {
                            String oldValue = fieldObj.toString();
                            if (oldValue.contains(",")) {
                                String[] split = oldValue.split(",");
                                StringBuilder value = new StringBuilder();
                                for (String str : split) {
                                    String newValue = convert(name, str);
                                    value.append(newValue).append(",");
                                }

                                field.set(obj,
                                    value.toString().substring(0, value.lastIndexOf(",")));
                            } else {
                                String newValue = convert(name, fieldObj.toString());
                                field.set(obj, newValue);
                            }
                        }

                    } catch (IllegalAccessException e) {
                        log.error("替换枚举值失败。", e);
                    }
                } else {
                    try {
                        field.setAccessible(true);
                        replace(field.get(obj));
                    } catch (IllegalAccessException e) {
                        log.error("替换枚举值失败。", e);
                    }
                }
            }
        }
    }

    /**
     * 通过类型和value获取新值
     *
     * @param type dic_group
     * @param old  dic_value
     * @return 新值，没有数据返回旧值
     */
    private String convert(String type, String old) {
        String dicGroup = "";
        if (ReplaceFieldConstant.dicGroupMap.containsKey(type)) {
            dicGroup = ReplaceFieldConstant.dicGroupMap.getOrDefault(type, null);
        } else {
            dicGroup = CodeStringUtil.camel2Underline(type);
        }
        if (StringUtils.isNotBlank(dicGroup)) {
            log.info("convert -- "+dicGroup+"_"+old);
            DictionaryTest dicInfo = (DictionaryTest) redisTemplate
                .boundValueOps(dicGroup + "_" + old).get();
            if (null != dicInfo) {
                return dicInfo.getDicName();
            }

        }
        /*if (StringUtils.isNoneEmpty(dicGroup)) {
            QueryWrapper query = new QueryWrapper<>();
            query.eq("dic_group",dicGroup);
            query.eq("dic_value",old);
            DictionaryTest dicInfo = dictionaryTestService.getOne(query);
            if (null != dicInfo) {
                return dicInfo.getDicName();
            }
        }*/

        return old;
    }
}
