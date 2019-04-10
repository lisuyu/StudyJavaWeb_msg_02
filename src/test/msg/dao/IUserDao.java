package test.msg.dao;


import test.msg.model.Pager;
import test.msg.model.User;

public interface IUserDao {
    public void add(User user);
    public void delete(int id);
    public void update(User user);
    public User load(int id);
    public Pager<User> list(String con);
    public User Login(String username, String password);
}
