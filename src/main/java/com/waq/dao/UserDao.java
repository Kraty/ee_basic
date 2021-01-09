package com.waq.dao;

import com.waq.pojo.User;

public interface UserDao {

    User checkLogin(String uname, String upwd);

    User checkCookie(String uid);

}
