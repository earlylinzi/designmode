package com.early.shejimoshi.chouxianggongchang;

public class AccessUser implements IUser{
    public void insertUser(User user) {
        System.out.println("给Access中的User表增加一条user记录");
    }

    public User getUser() {
        System.out.println("从Access的User表中获取到一条记录");
        return null;
    }
}
