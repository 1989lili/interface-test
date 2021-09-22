package com.tuling.xxy.constant;

/**
 * handler类型枚举
 *
 * @author Norman
 * @date 2021-04-23
 */
public enum ReplaceHandlerEnum {
    /**
     * page 分页
     * list/arraylist 列表
     */
    PAGE("Page"), LIST("List"), ARRAYLIST("ArrayList"), DEFAULT("default");

    ReplaceHandlerEnum(String code) {
        this.code = code;
    }

    private String code;

    public String getCode() {
        return code;
    }

    public static String convert(String name) {
        for (ReplaceHandlerEnum value : ReplaceHandlerEnum.values()) {
            if (value.getCode().equals(name)) {
                return value.code;
            }
        }
        return ReplaceHandlerEnum.DEFAULT.code;
    }
}
