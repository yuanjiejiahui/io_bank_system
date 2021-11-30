package com.baizhi.service.impl;

import com.baizhi.controller.UserUtils;
import com.baizhi.dao.UsersDao;
import com.baizhi.entity.Users;
import com.baizhi.service.UsersService;

import java.util.List;

public class UsersServiceImpl implements UsersService {
    //service_>dao
    private UsersDao dao = new UsersDao();

    @Override
    public Users findUsersByTelAndPwd(String tel, String pwd) {
        List<Users> list = dao.read();//读取数据
        for (Users u : list) {
            String tels = u.getTel();
            String pwds = u.getPwd();
            if (tels.equals(tel) && pwds.equals(pwd)) {//手机号，密码相同
                System.out.println("登陆成功！");
                return u;
            }
        }
        return null;//失败
    }

    @Override
    public boolean addUsers(Users users) {
        List<Users> list = dao.read();
        list.add(users);
        return dao.write(list);
    }

    @Override
    public boolean isExistTel(String tel) {
        List<Users> list = dao.read();
        for (Users u : list) {
            if (u.getTel().equals(tel)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isExistEmail(String email) {
        List<Users> list = dao.read();
        for (Users u : list) {
            if (u.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    //改密
    @Override
    public boolean UpdatePwd1(String tel, String pwd) {
        List<Users> list = dao.read();//读取数据
        for (Users u : list) {
            String utel = u.getTel();
            if (utel.equals(tel)) {//密码相同
                u.setPwd(pwd);
                break;
            }
        }
        return dao.write(list);
    }

    //充值
    @Override
    public boolean addMoney(String tel, Double money) {
        List<Users> list = dao.read();//读取数据
        for (Users u : list) {
            String utel = u.getTel();
            if (utel.equals(tel)) {//密码相同
                u.setMoney(u.getMoney()+money);
                UserUtils.setUsers(u);
                break;
            }
        }
        return dao.write(list);
    }

    @Override
    public boolean deleteMoney(String tel, Double money) {
        List<Users> list = dao.read();//读取数据
        for (Users u : list) {
            String utel = u.getTel();
            if (utel.equals(tel)) {//密码相同

                u.setMoney(u.getMoney()-money);
                UserUtils.setUsers(u);

                break;
            }
        }
        return dao.write(list);
    }

}
