package com.waq.service;

import com.waq.pojo.User;

public interface UserService {

    User checkLogin(String username, String userpwd);

    User checkCookie(String uid);

}
