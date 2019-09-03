package com.early.duoxiancheng;

/**
 * 线程类
 */
public class PlusThread implements Runnable{

    public static int i;

    public void run() {
        for (int j = 0; j < 1000; j++) {
            i = i++;
        }
    }
}
