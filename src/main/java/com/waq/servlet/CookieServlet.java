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

public class CookieServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; utf-8");
        resp.setCharacterEncoding("utf-8");

        // 获取cookie信息
        Cookie[] cookies = req.getCookies();

        // 判断cookie是否存在
        if (cookies != null && cookies.length > 1) {

            String uid = "";
            for (Cookie cookie : cookies) {

                if (cookie.getName().equals("uid")) {
                    uid = cookie.getValue();
                }
                if ("".equals(uid)) {
                    resp.sendRedirect("login.jsp");
                } else {

                    UserService userService = new UserServiceImpl();
                    User user;
                    user = userService.checkCookie(uid);

                    if (user != null) {

                        req.getSession().setAttribute("user",
                                user);
                        int nums;
                        if (this.getServletContext().getAttribute("nums") != null) {

                            nums = (int) this.getServletContext().getAttribute("nums");
                            nums += 1;
                            this.getServletContext().setAttribute("nums", nums);
                            resp.getWriter().write(nums);

                        } else {
                            this.getServletContext().setAttribute("nums", 1);
                        }

                        req.getRequestDispatcher("index.jsp").forward(req, resp);
                        return;

                    }

                }

            }

        } else {
            req.getRequestDispatcher("Hi").forward(req, resp);
        }

    }

}
