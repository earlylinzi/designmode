package com.early.jianzaozhe;

/**
 * 需要构建的产品
 */
public class Product {
    private String a;
    private String b;
    private String c;

    public void show(){
        System.out.println( "组装好了：" + a + b + c);
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }
}
