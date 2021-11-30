package com.baizhi.test;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.List;

/**读取学生信息*/
public class ReadStu {
    public static void main(String[] args) {
        try {
            FileInputStream file=new FileInputStream("stu.data");
            ObjectInputStream in=new ObjectInputStream(file);
            List<Student> list= (List<Student>) in.readObject();//读取文件
            in.close();//关闭
            for(Student s:list){
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
