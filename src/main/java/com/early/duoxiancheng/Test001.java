package com.early.duoxiancheng;

import org.junit.Test;

/**
 * 测试1
 */
public class Test001 {

    static int count = 0;

    @Test
    public void test001(){
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new PlusThread());
            thread.start();
        }
        System.out.println(PlusThread.i);

    }






}
