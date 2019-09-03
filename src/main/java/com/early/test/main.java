package com.early.test;

import com.early.util.DateUtil;


import java.io.*;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {


    public static void main(String[] args) throws Exception {

        Integer i = null;
        System.out.println(1 == i);


    }

    private void m1(Object o) {
        System.err.println("object");
    }
    private void m1(String s) {
        System.err.println("string");
    }











    private static String  getRegionCodeFromSource(String source){
        if(null == source){
            return null;
        }
        int index = source.lastIndexOf("_");
        return source.substring(index+1, source.length());
    }






    public static void downResourceAndUpload() throws Exception {
        String realPath = "http://thirdwx.qlogo.cn/mmopen/vi_32/BgHpE3jibeScydvZYH4N0gwlacibzNzXh6L1nu0e9vhaEZUFzAiaGDrM6uTCA81BlDz99Ebjjk1ZNJB42PTxOL3uw/132";

        URL url = new URL(realPath);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5 * 1000);
        InputStream inStream = conn.getInputStream();//通过输入流获取图片数据

        String toPath = "E:\\ceshi.png";
        OutputStream outStream = new BufferedOutputStream(new FileOutputStream(toPath));

        byte[] buffer = new byte[1024];
        int len = 0;
        while( (len=inStream.read(buffer)) != -1 ){
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        outStream.close();

    }

    public static byte[] readInputStream(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while( (len=inStream.read(buffer)) != -1 ){
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        return outStream.toByteArray();
    }




    private static void getmymMethod2()  {
        Float i= 278.0F;
        Integer g = 10;
        boolean flag = false;
        for (int j = 0; j < 1000000 ; j++) {
            float v = i / g;
            String result = String.valueOf(v);
            if(result.length() > 4){
                flag = true;
                System.out.println(result);
            }
        }
        if(flag){

        }else{
            System.out.println("没有结果");
        }

    }

    private static void getmymMethod()  {
        //计算过期时间
        Date annualFeeEffectiveTime = new Date();
        long time = annualFeeEffectiveTime.getTime();
        long endTime = time + (((int)365) * (24 * 60 * 60 *1000L));
        Date experdTimeD = new Date(endTime);
        String expiredTime = null;
        try {
            expiredTime = DateUtil.formatDate(experdTimeD, DateUtil.DATE_FORMAT_FULL);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(expiredTime);
    }
}
