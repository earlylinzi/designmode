package com.early.chouxianggongchang;

/**
 * 客户端
 */
public class Client {


    public static void main(String[] args) {
        User user = new User();

//        SqlServerFactory factory = new SqlServerFactory();
        AccessFactory factory = new AccessFactory();
        /**
         * 如果这里可以需要修改数据库直接换成上面的代码就可以
         */

        IUser iu = factory.createUser();
        iu.insertUser(user);
        iu.getUser();

        Department department = new Department();
        IDepart depart = factory.createDepart();
        depart.insertDepart(department);
        depart.getDepartment();


    }


}
