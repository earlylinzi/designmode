package com.early.zhuangtaimoshi;

public class EveningState extends State {
    public void writeProgram(Work work) {
        if(work.getHour() < 19){
            System.out.println("现在时间："+work.getHour()+"点，加班中。。。。 ");
        }else{
            work.setState(new SleepingState());
            work.writeProgram();


        }
    }
}
