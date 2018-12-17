package com.early.shipeiqimoshi;

/**
 * 适配器
 * 现在的需求是：在调用Target.request() 方法
 *       实际调用的是Adaptee.specailRequest
 * 实现：一个继承一个关联关系
 */
public class Adaptor extends Target{

    Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        adaptee.specailRequest();
    }
}
