package com.baizhi.controller;

import com.baizhi.entity.Users;
import com.baizhi.service.UsersService;
import com.baizhi.service.impl.UsersServiceImpl;

import javax.swing.*;

/**
 * 用户管理
 */
public class UsersController {
    //controller-->service
    private UsersService usersService = new UsersServiceImpl();

    /**
     * 登陆
     */
    public Users usersLogin(String tel, String pwd) {
        return usersService.findUsersByTelAndPwd(tel, pwd);
    }
    /**
     * 注册
     */
    public boolean addUsers(String tel, String pwd, String name, String relName,
                            String cardNum, String email) {
        Users u = new Users(tel, pwd, name, relName, cardNum, email, 0);
        return usersService.addUsers(u);
    }
    /**
     * 改密1
     */
    public boolean UpdatePwd1(String tel,String oldpwd, String pwd) {
        Users u = usersService.findUsersByTelAndPwd(tel,oldpwd);
        if(u==null){
            return false;//原密码不正确
        }
        return usersService.UpdatePwd1(tel,pwd);
    }
    /**
     *
     * @param tel
     * @return
     */
    public boolean isExistTel(String tel) {
        return usersService.isExistTel(tel);
    }

    /**
     *
     * @param eamil
     * @return
     */
    public boolean isExistEmail(String eamil) {
        return usersService.isExistEmail(eamil);
    }

    /**充值*/
    public boolean addMoney(String tel, Double money){
        return usersService.addMoney(tel, money);
    }
    /**提现*/
    public boolean deleteMoney(String tel, Double money){
        return usersService.deleteMoney(tel, money);
    }



}
