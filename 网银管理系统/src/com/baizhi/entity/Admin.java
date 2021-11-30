package com.baizhi.entity;

import java.io.Serializable;

/**管理员*/
public class Admin implements Serializable {//Serializable序列化接口
    private String account;
    private String pwd;

    public Admin(String account, String pwd) {
        this.account = account;
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "account='" + account + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
