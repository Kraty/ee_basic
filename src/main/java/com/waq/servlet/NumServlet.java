package com.waq.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class NumServlet extends HttpServlet {

    // 初始化时加载访问次数
    public void init() {

        // 获取文件中网页计数器
        String path = this.getServletContext().getRealPath("/nums/nums.txt");
        // 声明流对象
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {

            fileReader = new FileReader(path);
            bufferedReader = new BufferedReader(fileReader);
            String nums = bufferedReader.readLine();
            System.out.println(nums);
            System.out.println(path);
            // this.getServletContext().setAttribute("nums", nums);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {

                bufferedReader.close();
                fileReader.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }

    // 销毁时载入访问次数
    public void destroy() {

        // 获取计数器
        int num = (int) this.getServletContext().getAttribute("nums");
        // 获取文件路径
        String path = this.getServletContext().getRealPath("/nums/nums.txt");

        // 声明流对象
        BufferedWriter writer = null;
        FileWriter fileWriter = null;

        try {

            fileWriter = new FileWriter(path);
            writer = new BufferedWriter(fileWriter);
            writer.write(num+"");
            writer.flush();
            System.out.println(num);
            System.out.println(path);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {

                fileWriter.close();
                writer.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

}
