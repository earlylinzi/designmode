package com.early.chouxianggongchang;

public class AccessDepartment implements IDepart{
    public void insertDepart(Department department) {
        System.out.println("给Access的部门表增加一条记录");
    }

    public Department getDepartment() {
        System.out.println("从Access的部门表中获取一条记录");
        return null;
    }
}
