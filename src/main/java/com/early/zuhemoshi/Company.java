package com.early.zuhemoshi;

/**
 * 公司接口
 */
public interface Company {
    void add(Company company);// 增加
    void delete(Company company);// 删除
    void display(int depth);// 显示
    void lineDuty();// 履行职责
}
