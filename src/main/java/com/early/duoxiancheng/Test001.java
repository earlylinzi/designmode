package com.early.duoxiancheng;

import org.junit.Test;

/**
 * 测试1
 */
public class Test001 {


    /**
     * 测试十个线程同时对一个变量进行++操作1000次
     */
    @Test
    public void test001(){
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new PlusThread());
            thread.start();
        }
        System.out.println(PlusThread.i);

    }






}
