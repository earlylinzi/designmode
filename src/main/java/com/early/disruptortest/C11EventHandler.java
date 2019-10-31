package com.early.disruptortest;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;


/**
 * C1-1消费者实现类  加上10
 * 如果不需要池化  只需要实现EventHandler接口
 * 如果需要池化只需要实现WorkHandler接口
 */
public class C11EventHandler implements EventHandler<LongEvent>, WorkHandler<LongEvent> {

    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        long number = longEvent.getNumber();
        number += 10;
        System.out.println(System.currentTimeMillis()+": c1-1 consumer finished.number=" + number);
    }

    @Override
    public void onEvent(LongEvent longEvent) throws Exception {
        long number = longEvent.getNumber();
        number += 10;
        System.out.println(System.currentTimeMillis()+": c1-1 consumer finished.number=" + number);
    }

}
