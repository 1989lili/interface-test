package com.tuling.xxy.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 需要替换的枚举字段名称常量，需要特殊处理的
 * 配置替换，需要维护字段和字典group的关系
 * @author xiongxy
 * @date 2021-09-11
 */
public class ReplaceFieldConstant {
    /**
     * 字段与字典分组对应关系
     */
    public static Map<String, String> dicGroupMap = new HashMap<>();

    /**
     * 代办类型
     */
    public static final String AGENCY_TYPE = "agencyType";


    static {
        dicGroupMap.put(AGENCY_TYPE, "agency_type");
    }
}
