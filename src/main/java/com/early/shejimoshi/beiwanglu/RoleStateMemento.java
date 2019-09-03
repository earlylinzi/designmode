package com.early.shejimoshi.beiwanglu;

/**
 * 角色状态备忘录
 */
public class RoleStateMemento {
    private int defense; //防守
    private int attack; // 攻击
    private int vitality;  // 生命值

    public RoleStateMemento(int defense, int attack, int vitality) {
        this.defense = defense;
        this.attack = attack;
        this.vitality = vitality;
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
