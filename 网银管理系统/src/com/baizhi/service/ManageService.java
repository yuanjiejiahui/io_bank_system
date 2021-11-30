package com.baizhi.service;

import com.baizhi.entity.Users;

import java.util.List;

public interface ManageService {
    /**
     * 根据用手机号查看所有用户
     * @return
     */
    public  List<Users> showUser(String tel);
}
