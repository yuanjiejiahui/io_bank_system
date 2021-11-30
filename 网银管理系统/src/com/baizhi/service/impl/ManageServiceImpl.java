package com.baizhi.service.impl;

import com.baizhi.dao.UsersDao;
import com.baizhi.entity.Users;
import com.baizhi.service.ManageService;

import java.util.ArrayList;
import java.util.List;

public class ManageServiceImpl implements ManageService {

    private UsersDao dao = new UsersDao();

    @Override
    public List<Users> showUser(String tel) {
        List<Users> list = dao.read();
        List<Users> slist = new ArrayList<>();
        for (Users b : list) {

            slist.add(b);
            System.out.println(b);

        }
        return slist;
    }
}

