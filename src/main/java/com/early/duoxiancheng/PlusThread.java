package com.early.duoxiancheng;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程类
 */
public class PlusThread implements Runnable{

    static CountDownLatch c;

    public PlusThread(CountDownLatch c){
        this.c = c;
    }

    public  static  AtomicInteger i = new AtomicInteger(0);

//    static int i;



    public static void increate(){
        i.incrementAndGet();
    }

    public void run() {
        for (int j = 0; j < 10000; j++) {
            increate();
        }
        c.countDown();
    }
}
