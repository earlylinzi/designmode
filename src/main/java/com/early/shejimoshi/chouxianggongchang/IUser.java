package com.early.shejimoshi.chouxianggongchang;

/**
 * 用户客户端访问  解除与具体数据库的耦合
 */
public interface IUser {

    void insertUser(User user);
    User getUser();



}
