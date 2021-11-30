package com.baizhi.dao;

import com.baizhi.entity.Admin;
import com.baizhi.entity.Banks;
import com.baizhi.entity.Users;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


/**操作banks的数据*/
public class BanksDao {
    /**读取数据*/
    public List<Banks> read(){
        List<Banks> list=new ArrayList<>();
        try {
            FileInputStream file=new FileInputStream("banks.data");
            ObjectInputStream in=new ObjectInputStream(file);
            list= (List<Banks>) in.readObject();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**写入数据*/
    public boolean write(List<Banks> list){
        try {
            FileOutputStream file=new FileOutputStream("banks.data");
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
        List<Banks> list = new ArrayList<>();
        list.add(new Banks("1",88888,"1","0"));
        BanksDao u = new BanksDao();
        u.write(list);
    }

}
