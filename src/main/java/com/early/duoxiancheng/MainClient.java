package com.early.duoxiancheng;

import java.util.concurrent.*;

public class MainClient {



    public static void main(String[] args) throws Exception {
//        ExecutorService exec = Executors.newCachedThreadPool();//工头
//        Future<Integer> submit1 = exec.submit(new IntTaskCallable01(2));
//        Future<Integer> submit2 = exec.submit(new IntTaskCallable02(2));
//        Future<Integer> submit3 = exec.submit(new IntTaskCallable03(2));
//        Future<Integer> submit4 = exec.submit(new IntTaskCallable04(2));

        IntTaskCallable01 intTaskCallable01 = new IntTaskCallable01(3);
        FutureTask<Integer> task = new FutureTask<>(intTaskCallable01);
        new Thread(task).start();
        Integer integer = task.get();


//        Integer count = submit1.get() + submit2.get() +submit3.get() + submit4.get();

        System.out.println(integer);


    }



}
