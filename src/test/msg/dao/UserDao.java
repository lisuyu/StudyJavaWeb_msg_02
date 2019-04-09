package test.msg.dao;

import test.msg.model.MsgException;
import test.msg.model.Pager;
import test.msg.model.User;
import test.msg.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements IUserDao {
    @Override
    public void add(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select count(*) from t_user where username=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getUsername());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                if (resultSet.getInt(1)>0) throw new MsgException("用户已经存在，不能继续添加。");
            }
            sql = "insert into t_user values (null,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getNickname());
            preparedStatement.setInt(4,user.getStatus());
            preparedStatement.setInt(5,user.getType());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(resultSet);
            DBUtil.close(preparedStatement);
            DBUtil.close(connection);
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getConnection();
            User user = load(id);
            if (user.getUsername().equals("admin")) throw new MsgException("超级管理员账号不可删除");
            String sql = "delete from t_user where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(preparedStatement);
            DBUtil.close(connection);
        }
    }

    @Override
    public void update(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "update t_user set password=?,nickname=?,status=?,type=? where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getPassword());
            preparedStatement.setString(2,user.getNickname());
            preparedStatement.setInt(3,user.getStatus());
            preparedStatement.setInt(4,user.getType());
            preparedStatement.setInt(5,user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(preparedStatement);
            DBUtil.close(connection);
        }
    }

    @Override
    public User load(int id) {
        User user = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from t_user where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setNickname(resultSet.getString("nickname"));
                user.setStatus(resultSet.getInt("status"));
                user.setType(resultSet.getInt("type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(resultSet);
            DBUtil.close(preparedStatement);
            DBUtil.close(connection);
        }
        return user;
    }

    @Override
    public Pager<User> list(String condition, int pageSize, int pageIndex) {
        List<User> list = new ArrayList<User>();
        User user = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Pager<User> pages = new Pager<User>();
        try {
            if (pageIndex<=0) pageIndex=1;
            int start = (pageIndex-1)*pageSize;
            connection = DBUtil.getConnection();
            String sql = "select * from t_user";
            String sqlCount = "select count(*) from t_user";
            if (condition!=null||"".equals(condition)){
                sql+=" where username like '%"+condition+"%' or nickname like '%"+condition+"%'";
                System.out.println(sql);
                sqlCount+=" where username like '%"+condition+"%' or nickname like '%"+condition+"%'";
            }
            sql+=" limit ?,?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,start);
            preparedStatement.setInt(2,pageSize);
//            if (condition==null||"".equals(condition)){
//                sql+=" limit ?,?";
//                preparedStatement=connection.prepareStatement(sql);
//                preparedStatement.setInt(1,start);
//                preparedStatement.setInt(2,pageSize);
//            }else{
//                sql+=" where username like ? or nickname like ?";
//                System.out.println(sql);
//                preparedStatement = connection.prepareStatement(sql);
//                preparedStatement.setString(1,"%"+condition+"%");
//                preparedStatement.setString(2,"%"+condition+"%");
//            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setNickname(resultSet.getString("nickname"));
                user.setStatus(resultSet.getInt("status"));
                user.setType(resultSet.getInt("type"));
                list.add(user);
            }
            preparedStatement = connection.prepareStatement(sqlCount);
            resultSet = preparedStatement.executeQuery();
            int totalRecord = 0;
            while (resultSet.next()){
                totalRecord = resultSet.getInt(1);
            }
            int totalPage = (totalRecord-1)/pageSize+1;
            pages.setPageIndex(pageIndex);
            pages.setPageSize(pageSize);
            pages.setTotalPage(totalPage);
            pages.setTotalRecord(totalRecord);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(resultSet);
            DBUtil.close(preparedStatement);
            DBUtil.close(connection);
        }
        pages.setDates(list);
        return pages;
    }

    @Override
    public User Login(String username, String password) {
        User user = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from t_user where username=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setNickname(resultSet.getString("nickname"));
                user.setStatus(resultSet.getInt("status"));
                user.setType(resultSet.getInt("type"));
            }
            if (user==null) throw new MsgException("用户名不存在");
            if (!user.getPassword().equals(password)) throw new MsgException("密码不正确！");
            System.out.println(user.getStatus());
            if (user.getStatus()==0) throw new MsgException("此用户已停用！");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(resultSet);
            DBUtil.close(preparedStatement);
            DBUtil.close(connection);
        }
        return user;
    }


}
