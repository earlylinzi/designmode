package com.early.shejimoshi.zuhemoshi;

import com.early.util.CommonUtil;

/**
 *  人力资源部门
 */
public class HRDepartment extends AbstractCompany{

    public HRDepartment(String name) {
        super(name);
    }

    public void add(Company company) {
        System.out.println("叶子节点不允许增加分支");
    }

    public void delete(Company company) {
        System.out.println("叶子节点不允许上删除分支");
    }

    public void display(int depth) {
        System.out.println(CommonUtil.getStribgByDepth("-",depth)+ name);
    }

    public void lineDuty() {
        System.out.println(name + "  员工招聘培训管理");
    }
}
