package com.baizhi.service.impl;

import com.baizhi.dao.BanksDao;
import com.baizhi.entity.Banks;
import com.baizhi.service.BanksService;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 添加和展示
 */
public class BanksServiceImpl implements BanksService {
    private BanksDao dao = new BanksDao();

    @Override
    public boolean addBanks(Banks banks) {

        List<Banks> list = dao.read();
        for(Banks b: list ){
            if (!b.getBankNum().equals(banks.getBankNum()) && !b.getBankName().equals(banks.getBankName())){
                list.add(banks);
                return dao.write(list);
            }
        }
        return false;
    }

    @Override
    public List<Banks> showBanksByTel(String tel) {
        List<Banks> list = dao.read();
        List<Banks> ulist = new ArrayList<>();
        for (Banks b : list) {
            if (b.getTel().equals(tel)) {
                ulist.add(b);
            }
        }
        return ulist;
    }

    @Override
    public boolean deleteMoney(String banksNum, Double money) {
        List<Banks> list = dao.read();
        for (Banks b : list) {
            if (banksNum.equals(b.getBankNum())) {
                Double mo = b.getMoney();
                if (mo - money < 0) {
                    return false;
                } else {
                    b.setMoney(mo - money);

                }
            }
        }
        return dao.write(list);
    }

    @Override
    public boolean a_ddMoney(String banksNum, Double money) {
        List<Banks> list = dao.read();
        for (Banks b : list) {
            if (banksNum.equals(b.getBankNum())) {
                Double mo = b.getMoney();
                if (money < 0) {
                    return false;
                } else {
                    b.setMoney(mo + money);
                }
            }
        }
        return dao.write(list);
    }

}