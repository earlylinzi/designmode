package com.early.jianzaozhe;

/**
 * 指挥者类
 * 指挥者的构建方法通过传入不同的具体的构建类完成不同的构建
 * 通过多态的特性完成指挥
 */
public class Director {
    public void custruct(Builder builder){
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
    }

}
