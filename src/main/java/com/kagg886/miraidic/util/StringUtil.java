package com.kagg886.miraidic.util;

public class StringUtil {
    public static String replace(String source,String replace,String target) {
        while (source.contains(replace)) {
            source = source.replace(replace,target);
        }
        return source;
    }
}
