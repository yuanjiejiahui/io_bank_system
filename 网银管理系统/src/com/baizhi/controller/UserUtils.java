package com.baizhi.controller;

import com.baizhi.entity.Users;

import javax.swing.*;

public class UserUtils {

    /**
     * 关闭主程序
     */
    private static JFrame frame1;
    public static void setClose(JFrame frame){
        frame1 = frame;
    }
    public static void Close(){
        frame1.dispose();
    }

    /**
     * 刷新个人信息
     */
    private static Users user1;
    public static void setUsers(Users user){user1 = user;}
    public static Users getUsers(){return user1;}
}
