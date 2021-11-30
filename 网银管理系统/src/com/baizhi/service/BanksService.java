package com.baizhi.service;

import com.baizhi.entity.Banks;

import java.util.List;

public interface BanksService {

    /**
     * 添加
     */
    public boolean addBanks(Banks banks);

    /**
     * 根据用账户查看所有银行卡
     */
    public List<Banks> showBanksByTel(String tel);

    /**
     * 提现
     */
    public boolean deleteMoney(String banksNum,Double money);
    /**
     * 增加（转账）
     */
    public boolean a_ddMoney(String banksNum,Double money);

}