package com.early.zhuangtaimoshi;

public class NoonState extends State {
    public void writeProgram(Work work) {
        if(work.getHour() < 13){
            System.out.println("现在时间："+work.getHour()+"点，午饭要吃好 ");
        }else{
            work.setState(new AfterNoonState());
            work.writeProgram();
        }
    }
}
