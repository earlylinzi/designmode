package com.early.wanxiaoyun;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.util.*;

public class WanXiaoYunClient {


    public static void main(String[] args) {

        Map<String, String> sPara = new HashMap<String, String>();
        sPara.put("appkey", "O2N6V9HDEFTJPEKA0SRAX4E0262VGQZB");
        sPara.put("personId", "110108198010013009");
        String currentTime = String.valueOf(System.currentTimeMillis());
        sPara.put("timestamp", currentTime);
        sPara.put("name", "赵新盼");
        sPara.put("userType", "1");
        sPara.put("orgId", "430921");
        sPara.put("orgName", "清华同方测试学校");

        String signature_temp= createLinkString(sPara);

        String signature = sign(signature_temp, "9HVRQYS60B0ZB5LLKL6RSMJI5SZXE02IR61LKKTWM5XGR2G0", "utf-8");


        String query_string ="signature="+ signature + "&" + signature_temp;


        System.out.println("http://123.57.234.192:9090/a/thirdAuto/openWeb/qhtf?" + query_string);


    }

    public static String createLinkString(Map<String, String> params) {
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);
        String prestr = "";
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);
            if (i == keys.size() - 1) {//拼接时，不包括最后一个&字符
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }
        return prestr;
    }


    public static String sign(String text, String key, String input_charset) {
        text = text + key;
        return DigestUtils.md5Hex(getContentBytes(text, input_charset));
    }

    private static byte[] getContentBytes(String content, String charset) {
        if (charset == null || "".equals(charset)) {
            return content.getBytes();
        }
        try {
            return content.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
        }
    }


}
