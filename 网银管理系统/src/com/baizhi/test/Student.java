package com.baizhi.test;


import java.io.Serializable;

/**学生类
 * 类命名：首字母必须大写
 * */
public class Student implements Serializable {
    //1.私有化属性  姓名，班级，年龄，性别
    private int id;
    private String name;
    private String clas;
    private int age;
    private String sex;
    //2.创建构造方法/函数  ALT+Insert  -->construtor
    public Student(int id, String name, String clas, int age, String sex) {
        this.id = id;
        this.name = name;
        this.clas = clas;
        this.age = age;
        this.sex = sex;
    }
    //3.创建get/set方法 ALT+Insert
    //4.toString()方法  ALT+Insert
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", clas='" + clas + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
