package com.early.shejimoshi.dailimoshi;

/**
 * 追求者
 */
public class Persuiter implements SendGift{
    private String name;
    private SchoolGirl mm;
    public Persuiter(SchoolGirl mm,String name){
        this.mm = mm;
        this.name = name;
    }
    public Persuiter(SchoolGirl mm){
        this.mm = mm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sendBabi() {
        System.out.println(name + "送 "+ mm.getName() +" 的芭比");
    }

    public void sendFlower() {
        System.out.println(name + "送"+ mm.getName() +"的鲜花");
    }

    public void sendChocolate() {
        System.out.println(name + "送" + mm.getName() + "的巧克力");
    }
}
