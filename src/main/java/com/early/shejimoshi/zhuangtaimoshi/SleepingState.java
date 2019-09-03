package com.early.shejimoshi.zhuangtaimoshi;

public class SleepingState extends State {
    public void writeProgram(Work work) {
        if(work.getHour() < 21){
            System.out.println("现在时间："+work.getHour()+"点，加班好累啊 都快睡着了 ");
        }else{
            work.setState(new RestState());
            work.writeProgram();
        }
    }
}
