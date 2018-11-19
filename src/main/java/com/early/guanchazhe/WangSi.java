package com.early.guanchazhe;

import java.util.Observable;
import java.util.Observer;

public class WangSi implements Observer {
    public void update(Observable o, Object arg) {
        System.out.println("王四观察到韩非子在活动了，开始崇拜。。");
    }
}
