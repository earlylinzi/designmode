package com.early.shejimoshi.dailimoshi;

/**
 * 调用的客户端
 */
public class Client {
    public static void main(String[] args) {

        SchoolGirl jiaojiao = new SchoolGirl("jiaojiao");
        Proxy proxy = new Proxy(jiaojiao);

        proxy.sendBabi();
        proxy.sendChocolate();
        proxy.sendFlower();

    }


}

