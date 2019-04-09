package test.msg.dao;


import test.msg.model.User;

import java.util.List;

public interface IUserDao {
    public void add(User user);
    public void delete(int id);
    public void update(User user);
    public User load(int id);
    public List<User> list(String con);
    public User Login(String username, String password);
}
