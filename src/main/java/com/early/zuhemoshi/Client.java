package com.early.zuhemoshi;

public class Client {

    public static void main(String[] args) {
        ConcreteCompany root = new ConcreteCompany("北京总公司");
        root.add(new HRDepartment("总公司人力部"));
        root.add(new FinanceDepartment("总公司财务部"));

        ConcreteCompany company = new ConcreteCompany("上海华东分公司");
        company.add(new HRDepartment("上海华东分公司人力部"));
        company.add(new FinanceDepartment("上海华东分公司财务部"));
        root.add(company);

        ConcreteCompany company1 = new ConcreteCompany("南京分公司");
        company1.add(new HRDepartment("南京分公司人力部"));
        company1.add(new FinanceDepartment("南京分公司财务部"));
        root.add(company1);

        System.out.println("结构图：");
        root.display(1);

        System.out.println("职责：");
        root.lineDuty();
    }

}
