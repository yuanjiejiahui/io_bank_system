package com.baizhi.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class IOTest {
    public static void main(String[] args) {
        Student s=new Student(123,"张三","大数据1班",18,"男");
        Student s1=new Student(124,"里斯","大数据2班",19,"女");
        Student s2=new Student(125,"威威","大数据3班",16,"男");
        Student s3=new Student(126,"这里","大数据4班",18,"女");
        Student s4=new Student(127,"色素","大数据5班",19,"男");
        Student s5=new Student(128,"订单","大数据6班",18,"女");
        List<Student> list=new ArrayList<>();
        list.add(s);
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        //把数据存入文件中
        try {
            FileOutputStream file=new FileOutputStream("stu.data");//需要处理异常
            //写入对象的流
            ObjectOutputStream out=new ObjectOutputStream(file);
            out.writeObject(list);//存对象，把对象存入文件
            out.close();//关闭流
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
