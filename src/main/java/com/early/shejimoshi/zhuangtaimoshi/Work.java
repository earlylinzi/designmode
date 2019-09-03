package com.early.shejimoshi.zhuangtaimoshi;

/**
 * 工作的实体类
 */
public class Work {
    private Integer hour;
    private Boolean isFinished;
    private State current;
    public void writeProgram(){
        current.writeProgram(this);
    }

    // 初始化上午的状态
    public Work() {
        current = new MorningState();
    }

    public State getState() {
        return current;
    }

    public void setState(State state) {
        this.current = state;
    }

    public Boolean getFinished() {
        return isFinished;
    }

    public void setFinished(Boolean finished) {
        isFinished = finished;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }
}
