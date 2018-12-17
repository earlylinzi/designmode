package com.early.beiwanglu;

/**
 * 游戏角色
 */
public class GameRole {
    private int defense; //防守
    private int attack; // 攻击
    private int vitality;  // 生命值
    //保存角色状态
    public RoleStateMemento saveState(){
        return (new RoleStateMemento(defense,attack,vitality));
    }
    //恢复角色状态
    public void  recoveryState(RoleStateMemento memento){
        this.attack = memento.getAttack();
        this.vitality = memento.getVitality();
        this.defense = memento.getDefense();
    }

    public void getInitState(){
        this.defense = 100;
        this.attack = 100;
        this.vitality = 100;
    }

    public void stateDisplay(){
        System.out.println("角色当前状态：");
        System.out.println("体力：" + this.vitality);
        System.out.println("攻击力：" + this.attack);
        System.out.println("防守：" + this.defense);
        System.out.println("===============================");
    }

    public void fight(){
        this.defense = 0;
        this.attack = 0;
        this.vitality = 0;
    }






    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getVitality() {
        return vitality;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }
}
