package com.early.chouxianggongchang;

/**
 * 实现工厂类接口实例化AccessUser
 */
public class AccessFactory implements IFactory {
    public IUser createUser() {
        return new AccessUser();
    }

    public IDepart createDepart() {
        return new AccessDepartment();
    }
}
