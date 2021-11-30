package com.baizhi.test;

import java.util.ArrayList;
import java.util.List;

/**集合练习*/
public class ArrarsTest {
    public static void main(String[] args) {
        //声明  <>泛型(基本数据类型需要转换为包装类)
        List<Integer> list=new ArrayList<>();
        //添加
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        //集合长度
        int size=list.size();
        System.out.println("集合长度："+size);
        //删除   下标时从0开始的
        list.remove(0);
        //修改 根据下标直接赋值
        list.set(0,12);
        //查看  根据下标获取数据
        int a=list.get(0);
        System.out.println("第一条数据："+a);
        //查看所有----遍历集合
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        System.out.println("****************************************");
        //第二种遍历方式
        //(类型 别名:集合)
        for (Integer i:list){
            //打印语句快捷方式sout
            System.out.println(i);
        }

    }
}
