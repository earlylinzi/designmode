package com.early.test;

public class main {


    public static void main(String[] args) {
        System.out.println(getmymMethod());
    }

    private static String getmymMethod(){
        return (Thread.currentThread().getStackTrace()[2]).getFileName();
    }
}
