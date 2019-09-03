package com.early.shejimoshi.chouxianggongchang;

public class SqlServerUser implements IUser{
    public void insertUser(User user) {
        System.out.println("给sqlserver中的User表增加一条user记录");
    }

    public User getUser() {
        System.out.println("从sqlserver的User表中获取到一条记录");
        return null;
    }
}
