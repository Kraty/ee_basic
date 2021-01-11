package com.waq.servlet;

import java.io.BufferedReader;
import java.io.FileReader;

public class H {

    public static void main(String[] args) {

        FileReader fileReader = null;
        String path = "D:/apache-tomcat-9.0.31/webapps/ee_basic/nums/nums.txt";
        BufferedReader reader = null;

        try {

            fileReader = new FileReader(path);
            reader = new BufferedReader(fileReader);
            String nums = reader.readLine();
            System.out.println(nums);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {

                fileReader.close();
                reader.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

}
