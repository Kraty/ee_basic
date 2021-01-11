package com.waq.servlet;

import com.waq.pojo.User;
import com.waq.service.UserService;
import com.waq.service.UserServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // 设置请求编码格式
        req.setCharacterEncoding("utf-8");
        // 设置响应编码格式
        resp.setContentType("text/html; charset=utf-8");

        // 创建业务层对象
        UserService userService = new UserServiceImpl();
        String uname = req.getParameter("uname");
        String upwd = req.getParameter("upwd");

        // 获得User对象
        User user;
        user = userService.checkLogin(uname, upwd);

        if (user != null) {

            // 创建cookie对象
            Cookie cookie = new Cookie("uid", user.getUid() + "");
            // 设置时间期限
            cookie.setMaxAge(3 * 24 * 3600);
            // 设置存放路径
            cookie.setPath("/ee_basic/ck");
            System.out.println("value:" + cookie.getValue());
            // 添加cookie
            resp.addCookie(cookie);

            // 获取session对象
            HttpSession session = req.getSession();
            session.setAttribute("user", user);

            // 创建网站计数器
            ServletContext context = this.getServletContext();

            if (context.getAttribute("nums") != null) {

                int nums = (int) context.getAttribute("nums");
                nums += 1;
                context.setAttribute("nums", nums);

            } else {
                context.setAttribute("nums", 1);
            }
            resp.sendRedirect("index.jsp");
        } else {
            resp.sendRedirect("login.jsp");
        }

    }

}
