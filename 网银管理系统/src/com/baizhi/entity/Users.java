package com.baizhi.entity;

import java.io.Serializable;

/**用户类*/
public class Users implements Serializable {
    private String tel;
    private String pwd;
    private String name;
    private String relName;
    private String cardNum;
    private String email;
    private double money;
    // ALT+ INsert  getterandSetter  toString() constructor
    public Users(String tel, String pwd, String name, String relName, String cardNum, String email, double money) {
        this.tel = tel;
        this.pwd = pwd;
        this.name = name;
        this.relName = relName;
        this.cardNum = cardNum;
        this.email = email;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Users{" +
                "tel='" + tel + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", relName='" + relName + '\'' +
                ", cardNum='" + cardNum + '\'' +
                ", email='" + email + '\'' +
                ", money=" + money +
                '}';
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelName() {
        return relName;
    }

    public void setRelName(String relName) {
        this.relName = relName;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
