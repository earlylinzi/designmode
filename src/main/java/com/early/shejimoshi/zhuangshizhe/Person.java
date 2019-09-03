package com.early.shejimoshi.zhuangshizhe;

/**
 *  需要被装饰的对象
 */
public class Person {
    private String name;

    public Person(){}

    public Person(String name) {
        this.name = name;
    }
    public void show(){
        System.out.println("装扮的" + name);
    }
}
