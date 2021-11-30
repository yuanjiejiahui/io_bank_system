package com.baizhi.dao;

import com.baizhi.entity.Admin;
import com.baizhi.entity.Users;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**用户*/
public class UsersDao {
    /**读取数据*/
    public List<Users> read(){
        List<Users> list=new ArrayList<>();
        try {
            FileInputStream file=new FileInputStream("users.data");
            ObjectInputStream in=new ObjectInputStream(file);
            list= (List<Users>) in.readObject();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**写入数据*/
    public boolean write(List<Users> list){
        try {
            FileOutputStream file=new FileOutputStream("users.data");
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
        List<Users> list = new ArrayList<>();
        list.add(new Users("1","1","1","1","1","1",0));
        UsersDao u = new UsersDao();
        u.write(list);
    }
}
