package com.early.test;

import com.early.util.DateUtil;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;

public class main {

    static class User{
        private int age;
        private String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    /**
     * list = list.stream().peek(x -> {
     *     if (x.getDateLong == 20191023){
     *         x.getTimeList.set(new TimeModel(aaa,bbb));
     *     }
     * }).collect(Collectors.toList());
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {







//        List<User> users = getSource();
////        users.stream().peek(x->{
////           if(x.getAge()== 5){
////               x.setName("Jim");
////           }
////        });
//
////        List<Integer> collect = users.stream().map(item -> item.getAge()).collect(Collectors.toList());
////        Map<String,User> map = new HashMap<>();
////        users.stream().forEach(user->map.put(user.getName(),user));
////        Map<String, User> userMap = users.stream().collect(Collectors.toMap(User::getName, Function.identity()));
////        Map<String, User> userMap = users.stream().collect(Collectors.toMap(User::getName, user->user));
//
//        users.forEach(n->{
//
//        });


    }

    private static List<User> getSource(){
        ArrayList<User> users = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            users.add(new User(i,"lucy"+i));
        }
        return users;
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
