package com.early.shejimoshi.zhuangshizhe;

/**
 * 服饰类  集成Person类
 */
public class Finery extends Person{
    protected Person component;
    public void decorate(Person component){
        this.component = component;
    }
    @Override
    public void show(){
        if(component != null){
            component.show();
        }
    }

}
