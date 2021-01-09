package com.waq.dao;

import com.waq.pojo.User;

import java.sql.*;

public class UserDaoImpl implements UserDao {

    // 登录检查
    public User checkLogin(String uname, String upwd) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet set = null;
        User user = null;
        String url = "jdbc:mysql://localhost:3306/study?serverTimezone=UTC";
        String username = "root";
        String password = "789,,wang";

        try {

            // 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 创建连接
            connection = DriverManager.getConnection(url, username, password);
            // 创建statement对象
            statement = connection.prepareStatement("select * from USER where uname = ? and upwd = ?");
            statement.setString(1, uname);
            statement.setString(2, upwd);
            // 执行语句
            set = statement.executeQuery();
            while (set.next()) {

                user = new User();
                user.setUid(set.getInt("uid"));
                user.setUname(set.getString("uname"));
                user.setUpwd(set.getString("upwd"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {

                if (set != null) set.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return user;

    }

    // cookie检查
    public User checkCookie(String uid) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet set = null;
        User user = null;
        String url = "jdbc:mysql://localhost:3306/study?serverTimezone=UTC";
        String username = "root";
        String password = "789,,wang";

        try {

            // 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 创建连接
            connection = DriverManager.getConnection(url, username, password);
            // 创建statement对象
            statement = connection.prepareStatement("select * from USER where uid = ?");
            statement.setString(1, uid);
            // 执行语句
            set = statement.executeQuery();
            while (set.next()) {

                user = new User();
                user.setUid(set.getInt("uid"));
                user.setUname(set.getString("uname"));
                user.setUpwd(set.getString("upwd"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {

                if (set != null) set.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return user;
    }

}
