package com.baizhi.service;

import com.baizhi.entity.Users;

/**用户的服务层*/
public interface UsersService {
    /**根据手机号和密码查找用户*/
    public Users findUsersByTelAndPwd(String tel,String pwd);
    /**添加用户*/
    public boolean addUsers(Users users);
    /**验证手机号是否存在*/
    public boolean isExistTel(String tel);
    /**验证邮箱是否存在*/
    public boolean isExistEmail(String email);
    /**改密1*/
    public boolean UpdatePwd1(String tel,String pwd);
    /**
     * 充值
     */
    public boolean addMoney(String tel,Double money);
    /**
     * 转账
     */
    public boolean deleteMoney(String tel,Double money);

}
