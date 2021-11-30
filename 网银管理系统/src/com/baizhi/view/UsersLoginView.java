package com.baizhi.view;

import com.baizhi.controller.UsersController;
import com.baizhi.entity.Users;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 * 用户登陆界面
 */
public class UsersLoginView extends JFrame implements MouseListener {
    private JPanel jp;
    private JLabel top;
    private JPanel bom;
    private JLabel nameJL, pwdJL;
    private JTextField nameJF;
    private JPasswordField pwdJF;
    private JButton login, reg;

    public UsersLoginView() {
        jp = new JPanel();
        jp.setLayout(new BorderLayout());

        top = new JLabel();
        ImageIcon icon = new ImageIcon("img/logo.png");
        icon.setImage(icon.getImage().getScaledInstance(300, 50, Image.SCALE_DEFAULT));
        top.setIcon(icon);
        top.setBorder(new EmptyBorder(20, 70, 20, 30));
        jp.add(top, BorderLayout.NORTH);

        bom = new JPanel();
        bom.setLayout(new GridLayout(3, 2, 20, 20));
        bom.setBorder(new EmptyBorder(0, 40, 30, 40));
        nameJL = new JLabel("手机号：", JLabel.RIGHT);
        nameJL.setIcon(new ImageIcon("img/username_icon.png"));
        nameJF = new JTextField(20);
        nameJF.setBorder(new EmptyBorder(0, 0, 0, 20));
        pwdJL = new JLabel("密    码：", JLabel.RIGHT);
        pwdJL.setIcon(new ImageIcon("img/password_icon.png"));
        pwdJF = new JPasswordField(20);
        pwdJF.setBorder(new EmptyBorder(0, 0, 0, 20));
        login = new JButton("登录");
        login.setName("login");
        login.addMouseListener(this);
        reg = new JButton("注册");
        reg.setName("reg");
        reg.addMouseListener(this);

        bom.add(nameJL);
        bom.add(nameJF);
        bom.add(pwdJL);
        bom.add(pwdJF);
        bom.add(login);
        bom.add(reg);
        jp.add(bom, BorderLayout.CENTER);
        this.add(jp);

        this.setTitle("WelTo百知转账管理系统！");//标题
        this.setSize(450, 300);//大小
        this.setLocationRelativeTo(null);//居中
        this.setResizable(false);//不允许改变文件大小
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭方式
        this.setVisible(true);//显示
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        String str = e.getComponent().getName();
        if (str.equals("login")) {
            String tel = nameJF.getText();
            String pwd = new String(pwdJF.getPassword());
            if (tel.equals("")) {
                JOptionPane.showMessageDialog(null, "手机号不能为空");
            } else if (pwd.equals("")) {
                JOptionPane.showMessageDialog(null, "密码不能为空");
            } else {
                UsersController usersController = new UsersController();
                Users users = usersController.usersLogin(tel, pwd);
                if (users == null) {
                    JOptionPane.showMessageDialog(null, "登陆失败");
                } else {
                    System.out.println("成功，进入主界面");
                    MainView mainView = new MainView(users);
                    dispose();
                }
            }
        } else {
            AddUsersView ad = new AddUsersView(this);
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
