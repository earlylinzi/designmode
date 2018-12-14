package com.early.zhuangtaimoshi;

public class AfterNoonState extends State {
    public void writeProgram(Work work) {
        if(work.getHour() < 17){
            System.out.println("现在时间："+work.getHour()+"点，下午工作状态不错，继续努力 ");
        }else{
            work.setState(new EveningState());
            work.writeProgram();
        }
    }
}
