package com.early.beiwanglu;

/**
 * 状态管理者
 */
public class RoleStateCaretacker {
    private RoleStateMemento memento;
    public RoleStateMemento getMemento() {
        return memento;
    }
    public void setMemento(RoleStateMemento memento) {
        this.memento = memento;
    }
}
