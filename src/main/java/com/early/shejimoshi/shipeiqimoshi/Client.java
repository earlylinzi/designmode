package com.early.shejimoshi.shipeiqimoshi;

public class Client {

    public static void main(String[] args) {
        Target target = new Adaptor();
        target.request();
    }

}
