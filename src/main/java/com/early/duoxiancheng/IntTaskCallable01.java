package com.early.duoxiancheng;

import java.util.concurrent.Callable;

public class IntTaskCallable01 implements Callable<Integer> {
    private int id;
    public IntTaskCallable01(int id){
        this.id = id;
    }
    @Override
    public Integer call() throws Exception {
        return id;
    }
}
