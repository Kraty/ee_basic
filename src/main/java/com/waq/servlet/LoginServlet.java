package com.waq.servlet;

import com.waq.pojo.User;
import com.waq.service.UserService;
import com.waq.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        // 设置请求编码格式
        req.setCharacterEncoding("utf-8");
        // 设置响应编码格式
        resp.setContentType("text/html; charset=utf-8");
        UserService userService = new UserServiceImpl();
        String uname = req.getParameter("uname");
        String upwd = req.getParameter("upwd");
        User user = userService.checkLogin(uname, upwd);
        if (user != null) {

            Cookie cookie = new Cookie("uid", user.getUid()+"");
            cookie.setMaxAge(24*3600);
            cookie.setPath("/ee_basic/ck");
            System.out.println("value:" + cookie.getValue());
            resp.addCookie(cookie);
            resp.sendRedirect("index.jsp");

        } else {

            resp.sendRedirect("login.jsp");

        }

    }

}
