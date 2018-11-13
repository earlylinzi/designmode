package com.early.jianzaozhe;
/**
 * 直接建造者  实现Builder接口
 * 建造类实例化  产品   组装产品
 */
public class ConcreteBuilder implements Builder{

    private Product product = new Product();
    public void buildPartA() {
        product.setA("安装组件A");
    }

    public void buildPartB() {
        product.setB("安装组件B");

    }

    public void buildPartC() {
        product.setC("安装组件C");
    }

    public Product getResult(){
        return product;
    }

}
