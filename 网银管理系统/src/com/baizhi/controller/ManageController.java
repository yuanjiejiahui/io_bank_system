package com.baizhi.controller;

import com.baizhi.entity.Banks;
import com.baizhi.entity.Users;
import com.baizhi.service.ManageService;
import com.baizhi.service.impl.ManageServiceImpl;

import java.util.List;

public class ManageController {

    private ManageService manageService = new ManageServiceImpl() ;
        /**
         * 根据手机号查看所有的用户
         */
        public List<Users> showBanksByTel(String tel) {


            return manageService.showUser(tel);
        }
    }

