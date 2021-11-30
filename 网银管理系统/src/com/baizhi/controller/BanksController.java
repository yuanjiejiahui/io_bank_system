package com.baizhi.controller;

import com.baizhi.entity.Banks;
import com.baizhi.service.BanksService;
import com.baizhi.service.impl.BanksServiceImpl;

import java.util.List;

public class BanksController {
    private BanksService banksService = new BanksServiceImpl();


    /**添加*/
    public boolean addBanks(Banks banks) {
        return banksService.addBanks(banks);
    }

    /**
     * 根据手机号查看所有的银行卡
     */
    public List<Banks> showBanksByTel(String tel) {
        return banksService.showBanksByTel(tel);
    }
    /**
     * 扣钱
     */
    public boolean deleteMoney(String banksNum,Double money){
        return banksService.deleteMoney(banksNum,money);
    }
    /**
     * 加钱
     */
    public boolean addMoney(String banksNum,Double money){
        return banksService.a_ddMoney(banksNum,money);
    }

}
