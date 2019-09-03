package com.early.shejimoshi.zhuangshizhe;

/**
 * 客户端
 * 装饰者模式   对核心类Person进行装饰
 * 顺序不同  装饰的结果不同
 */
public class Client {

    public static void main(String[] args) {
        Person linzi = new Person("林子");

        TShirts tShirts = new TShirts();
        BigTrouser bigTrouser = new BigTrouser();

        tShirts.decorate(linzi);
        bigTrouser.decorate(tShirts);

        bigTrouser.show();


    }

}
