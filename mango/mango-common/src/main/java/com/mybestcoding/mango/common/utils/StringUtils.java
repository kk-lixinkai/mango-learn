package com.mybestcoding.mango.common.utils;

/**
 * 字符串工具类
 * Created By lixinkai on 2020/8/2
 */
public class StringUtils {


    public static boolean isBlank(String value) {
        return value == null || "".equals(value) || "null".equals(value) || "undefined".equals(value);
    }
}
