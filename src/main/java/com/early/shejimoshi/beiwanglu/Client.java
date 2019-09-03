package com.early.shejimoshi.beiwanglu;

public class Client {

    public static void main(String[] args) {
        //  大战boss前
        GameRole lixiaoyao = new GameRole();
        //初始化
        lixiaoyao.getInitState();
        lixiaoyao.stateDisplay();

        //保存进度
        RoleStateCaretacker stateAdmin = new RoleStateCaretacker();
        stateAdmin.setMemento(lixiaoyao.saveState());

        // 大战boss
        lixiaoyao.fight();
        lixiaoyao.stateDisplay();

        // 恢复之前状态
        lixiaoyao.recoveryState(stateAdmin.getMemento());
        lixiaoyao.stateDisplay();

    }




}
