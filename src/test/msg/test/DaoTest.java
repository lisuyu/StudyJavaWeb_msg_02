package test.msg.test;

import test.msg.dao.UserDao;
import test.msg.model.User;

import java.util.List;


public class DaoTest {
    public static void main(String[] args) {
        UserDao ud = new UserDao();
        List<User> users = ud.list("李");
        System.out.println(users.size());
        for (User user:users){
            System.out.println(user);
        }
    }
}
