package com.waq.service;

import com.waq.dao.UserDao;
import com.waq.dao.UserDaoImpl;
import com.waq.pojo.User;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    // 登录检查
    public User checkLogin(String uname, String upwd) {
        return userDao.checkLogin(uname, upwd);
    }

    // cookie检查
    public User checkCookie(String uid) {
        return userDao.checkCookie(uid);
    }

}
