package com.early.guanchazhe;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * 具体的被观察者  韩非类
 */
public class HanFei extends Observable
        implements IHanFeiZi{

    public void haveBreakFast() {
        System.out.println("韩非子：开始吃饭了！");
        super.setChanged();
        super.notifyObservers("韩非子在吃饭");
    }

    public void haveFun() {
        System.out.println("韩非子：开始娱乐了");
        super.setChanged();
        super.notifyObservers("韩非开始玩耍！");
    }

}
