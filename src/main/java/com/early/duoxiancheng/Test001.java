package com.early.duoxiancheng;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * 测试1
 */
public class Test001 {


//    @Test
//    public void test002() throws InterruptedException {
//
//        CountDownLatch count = new CountDownLatch(100);
//
//
//
//
//
//
//
//
//    }


    /**
     * 测试十个线程同时对一个变量进行++操作1000次
     */
    @Test
    public void test001() throws InterruptedException {

        int num = 10000;

        CountDownLatch count = new CountDownLatch(num);

        for (int i = 0; i < num; i++) {
            Thread thread = new Thread(new PlusThread(count));
            thread.start();
        }

//        try {
//            Thread.sleep(30000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        count.await();
        System.out.println(PlusThread.i);

    }






}
