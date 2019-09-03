package com.early.shejimoshi.guanchazhe;

import java.util.Observable;
import java.util.Observer;

/**
 * 具体的观察者  李斯类
 */
public class LiSi implements Observer {

    private void reportToQinShiHuang(String context){
        System.out.println("报告秦老板,韩非子有活动了：" + context);

    }


    public void update(Observable o, Object arg) {
        System.out.println("观察到韩非的活动开始向秦始皇报告了......" );
        this.reportToQinShiHuang(arg.toString());
        System.out.println("李斯： 汇报完毕......");
    }
}
