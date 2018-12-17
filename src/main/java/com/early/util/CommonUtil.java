package com.early.util;

public class CommonUtil {

    public static String getStribgByDepth(String str, int depth){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < depth; i++) {
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }
}
