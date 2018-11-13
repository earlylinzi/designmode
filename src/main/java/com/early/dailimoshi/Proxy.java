package com.early.dailimoshi;

/**
 * 代理类的关键是在于在实例化的时候首先实例化了真实类
 * 并且实现了和真是类同样的接口
 * 调用真是类的方法实现接口方法
 */
public class Proxy implements SendGift{

    private Persuiter persuiter;

    public Proxy(SchoolGirl mm){
        persuiter = new Persuiter(mm);
        persuiter.setName("haoge");
    }

    public void sendBabi() {
        persuiter.sendBabi();
    }

    public void sendFlower() {
        persuiter.sendFlower();
    }

    public void sendChocolate() {
        persuiter.sendChocolate();
    }
}
