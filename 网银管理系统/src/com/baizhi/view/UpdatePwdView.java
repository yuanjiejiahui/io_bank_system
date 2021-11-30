package com.baizhi.view;

import com.baizhi.controller.UserUtils;
import com.baizhi.controller.UsersController;
import com.baizhi.entity.Users;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UpdatePwdView extends JPanel implements MouseListener {

    private JPanel top;
    private JPanel bom;
    private JLabel newpwdJL, twopwdJL, oldpwdJL;
    private JPasswordField newpwdJF, twopwdJF, oldpwdJF;
    private JButton sub, clo;
    private Users users;

    public UpdatePwdView(Users users) {
        this.users = users;

        this.setLayout(new BorderLayout());
        top = new JPanel();
        JLabel topJl = new JLabel("个人信息展示");
        top.add(topJl);
        this.add(top, BorderLayout.NORTH);

        bom = new JPanel();
        bom.setLayout(new GridLayout(5, 2, 10, 10));

        EmptyBorder jbo = new EmptyBorder(10, 30, 0, 0);
        EmptyBorder fbo = new EmptyBorder(20, 0, 20, -20);

        oldpwdJL = new JLabel("原密码:", JLabel.CENTER);
        oldpwdJL.setIcon(new ImageIcon("img/password_icon.png"));
        oldpwdJL.setBorder(jbo);
        oldpwdJF = new JPasswordField(20);

        oldpwdJF.setBorder(fbo);
        bom.add(oldpwdJL);
        bom.add(oldpwdJF);

        newpwdJL = new JLabel("密码:", JLabel.CENTER);
        newpwdJL.setIcon(new ImageIcon("img/password_icon.png"));
        newpwdJL.setBorder(jbo);
        newpwdJF = new JPasswordField(20);

        newpwdJF.setBorder(fbo);
        bom.add(newpwdJL);
        bom.add(newpwdJF);

        twopwdJL = new JLabel("确认密码:", JLabel.CENTER);
        twopwdJL.setIcon(new ImageIcon("img/password_icon.png"));
        twopwdJL.setBorder(jbo);
        twopwdJF = new JPasswordField(20);
        twopwdJF.setBorder(fbo);
        bom.add(twopwdJL);
        bom.add(twopwdJF);

        sub = new JButton("提交");
        sub.setName("sub");
        sub.addMouseListener(this);
        bom.add(sub);
        this.add(bom);

        clo = new JButton("重置");
        clo.setName("clo");
        clo.addMouseListener(this);
        bom.add(clo);
        this.add(bom);

        this.add(bom, BorderLayout.CENTER);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String str = e.getComponent().getName();

        String tel = users.getTel();
        String pwd0 = new String(oldpwdJF.getPassword());
        String pwd1 = new String(newpwdJF.getPassword());
        String pwd2 = new String(twopwdJF.getPassword());
        switch (str) {
            case "sub":
                if (pwd0.equals("")) {
                    JOptionPane.showMessageDialog(null, "原密码不能为空！");
                    return;
                }
                if (pwd1.equals("")) {
                    JOptionPane.showMessageDialog(null, "新密码不能为空！");
                    return;
                }
                if (pwd2.equals("")) {
                    JOptionPane.showMessageDialog(null, "确认密码不能为空！");
                    return;
                }
                if (pwd0.equals(pwd1)) {
                    JOptionPane.showMessageDialog(null, "原密码与新密码不能相等！");
                    return;
                }

                if (!pwd1.equals(pwd2)) {//qqqqqqqqqqqqq
                    JOptionPane.showMessageDialog(null, "密码两次结果不一致！");
                    return;
                } else {
                    UsersController usersController = new UsersController();
                    boolean flag = usersController.UpdatePwd1(tel, pwd0, pwd1);
                    if (flag) {
                        JOptionPane.showMessageDialog(null, "修改成功！");
                        UserUtils.Close();

                        UsersLoginView usersLoginView=new UsersLoginView();
                    } else if (!flag) {
                        JOptionPane.showMessageDialog(null, "密码不正确！");
                    } else {
                        JOptionPane.showMessageDialog(null, "修改失败！");
                    }
                }
                oldpwdJF.setText(null);
                newpwdJF.setText(null);
                twopwdJF.setText(null);
                break;

            case "clo":
                oldpwdJF.setText(null);
                newpwdJF.setText(null);
                twopwdJF.setText(null);
                break;
            default:
                ;

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
