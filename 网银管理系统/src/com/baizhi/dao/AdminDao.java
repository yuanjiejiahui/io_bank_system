package com.baizhi.dao;

import com.baizhi.entity.Admin;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**操作admin的数据*/
public class AdminDao {
    /**读取数据*/
    public List<Admin> read(){
        List<Admin> list=new ArrayList<>();
        try {
            FileInputStream file=new FileInputStream("admin.data");
            ObjectInputStream in=new ObjectInputStream(file);
            list= (List<Admin>) in.readObject();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**写入数据*/
    public boolean write(List<Admin> list){
        try {
            FileOutputStream file=new FileOutputStream("admin.data");
            ObjectOutputStream out=new ObjectOutputStream(file);
            out.writeObject(list);
            out.close();
            return true;//写入成功
        } catch (Exception e) {
            e.printStackTrace();
            return false;//写入失败
        }
    }

    public static void main(String[] args) {
        List<Admin> list=new ArrayList<>();
        list.add(new Admin("admin","admin"));
        list.add(new Admin("sys","123456"));
        AdminDao dao=new AdminDao();
        dao.write(list);
        System.out.println("写入成功！");
        List<Admin> lists=dao.read();
        for (Admin ad:lists ) {
            System.out.println(ad);
        }
    }

}
