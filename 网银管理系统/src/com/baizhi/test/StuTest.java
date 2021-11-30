package com.baizhi.test;

import java.util.ArrayList;
import java.util.List;

/**测试类*/
public class StuTest {
    //main
    public static void main(String[] args) {
        //使用student类型的list实现增删改查
        Student s=new Student(123,"张三","大数据1班",18,"男");
        Student s1=new Student(124,"里斯","大数据2班",19,"女");
        Student s2=new Student(125,"威威","大数据3班",16,"男");
        Student s3=new Student(126,"这里","大数据4班",18,"女");
        Student s4=new Student(127,"色素","大数据5班",19,"男");
        Student s5=new Student(128,"订单","大数据6班",18,"女");


        List<Student> list=new ArrayList<>();//声明
        //添加
        list.add(s);
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        //删除  删除对象
        list.remove(s);
        //修改  名字为”订单“的学生名字为修改”李四“
        for (int i=0;i<list.size();i++){
            Student stu=list.get(i);
            //先判断学生名字是不是”订单“
            if(stu.getName().equals("订单")){
                stu.setName("李四");//修改了学生的姓名
            }
        }
        //查看  遍历
        for (Student st:list) {
            System.out.println(st);
        }
    }

}
