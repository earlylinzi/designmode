package com.early.jianzaozhe;

/**
 * 客户端
 */
public class Client {
    public static void main(String[] args) {

        /**
         * 建造者模式就是使得建造过程和表示代码分离，
         * 由于建造者隐藏了该产品是如何组装的所以若需要改变一个产品内部表示只需要再定义一个具体的建造类就可以了
         */
        Director director = new Director();

        ConcreteBuilder concreteBuilder = new ConcreteBuilder();
        director.custruct(concreteBuilder);
        Product product = concreteBuilder.getResult();
        product.show();

        ConcreteBuilder2 concreteBuilder2 = new ConcreteBuilder2();
        director.custruct(concreteBuilder2);
        Product result = concreteBuilder2.getResult();
        result.show();

    }




}
