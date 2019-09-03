package com.early.shejimoshi.chouxianggongchang;

/**
 * 实现IFactory工厂接口 实例化SqlServerUser
 */
public class SqlServerFactory implements IFactory{
    public IUser createUser() {
        return new SqlServerUser();
    }

    public IDepart createDepart() {
        return new SqlServerDepartment();
    }
}
