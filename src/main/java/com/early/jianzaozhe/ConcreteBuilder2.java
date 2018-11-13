package com.early.jianzaozhe;

/**
 * 第二个直接建造者
 */
public class ConcreteBuilder2 implements Builder{

    Product p = new Product();


    public Product getResult(){
        return p;
    }
    public void buildPartA() {
        p.setA("组装a+;");
    }

    public void buildPartB() {
        p.setB("组装b+;");

    }

    public void buildPartC() {
        p.setC("组装c+;");

    }
}
