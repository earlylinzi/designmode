package com.early.zhuangtaimoshi;

public class RestState extends State {
    public void writeProgram(Work work) {
        if(work.getHour() < 23){
            System.out.println("现在时间："+work.getHour()+"点，实在不行了 睡着了。。。。。。 ");
        }
    }
}
