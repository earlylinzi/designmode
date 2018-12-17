package com.early.zuhemoshi;

import com.early.util.CommonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体的公司类
 */
public class ConcreteCompany extends AbstractCompany{

    private List<Company> children = new ArrayList<Company>();

    public ConcreteCompany(String name) {
        super(name);
    }

    public void add(Company company) {
        children.add(company);
    }

    public void delete(Company company) {
        children.remove(company);
    }

    public void display(int depth) {
        System.out.println(CommonUtil.getStribgByDepth("-",depth) + name);
        for (Company c : children) {
            c.display(depth + 2);
        }
    }

    public void lineDuty() {
        for (Company c : children) {
            c.lineDuty();
        }
    }


    public List<Company> getChildren() {
        return children;
    }

    public void setChildren(List<Company> children) {
        this.children = children;
    }
}
