package com.baizhi.entity;

import java.io.Serializable;

/**银行卡*/
public class Banks implements Serializable {
    private String bankNum;
    private double money;
    private String bankName;
    private String tel;

    @Override
    public String toString() {
        return "Banks{" +
                "bankNum='" + bankNum + '\'' +
                ", money=" + money +
                ", bankName='" + bankName + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }

    public String getBankNum() {
        return bankNum;
    }

    public void setBankNum(String bankNum) {
        this.bankNum = bankNum;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Banks(String bankNum, double money, String bankName, String tel) {
        this.bankNum = bankNum;
        this.money = money;
        this.bankName = bankName;
        this.tel = tel;
    }
}
