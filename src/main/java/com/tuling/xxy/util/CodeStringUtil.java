package com.tuling.xxy.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeStringUtil {
    public static String camel2Underline(String source) {
        String target = source;
        Pattern humpPattern = Pattern.compile("[A-Z]");
        Matcher matcher = humpPattern.matcher(source);
        StringBuffer sb = new StringBuffer();
        if (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
            matcher.appendTail(sb);
            return sb.toString();
        }
        return target;
    }
}
