package com.early.guanchazhe;


import java.util.Observer;

/**
 * 调用的客户端
 */
public class Client {

    public static void main(String[] args) {
        Observer lisi = new LiSi();
        WangSi wangSi = new WangSi();
        HanFei hanfei = new HanFei();

        hanfei.addObserver(lisi);
        hanfei.addObserver(wangSi);

        hanfei.haveBreakFast();
    }




}
