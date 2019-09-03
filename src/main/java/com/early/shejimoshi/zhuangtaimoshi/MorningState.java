package com.early.shejimoshi.zhuangtaimoshi;

public class MorningState extends State{
    public void writeProgram(Work work) {
        if(work.getHour() < 11){
            System.out.println("现在时间："+work.getHour()+"点，上午工作精神百倍 ");
        }else{
            work.setState(new NoonState());
            work.writeProgram();
        }
    }
}
