package com.early.duoxiancheng;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程类
 */
public class PlusThread implements Runnable{

    public static  AtomicInteger i = new AtomicInteger(0);

    public void run() {
        for (int j = 0; j < 1000; j++) {
            i.getAndIncrement();
        }
    }
}
