package com.early.shejimoshi.chouxianggongchang;

public class SqlServerDepartment implements IDepart{
    public void insertDepart(Department department) {
        System.out.println("给sqlserver的部门表增加一条记录");
    }

    public Department getDepartment() {
        System.out.println("从sqlserver的部门表中获取一条记录");
        return null;
    }
}
