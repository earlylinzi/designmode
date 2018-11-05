package com.early.zhuangshizhe;

/**
 * 具体的装饰类（格子T恤 哈哈）
 */
public class TShirts extends Finery{

    @Override
    public void show() {
        System.out.print("大T恤   ");
        super.show();
    }


}
