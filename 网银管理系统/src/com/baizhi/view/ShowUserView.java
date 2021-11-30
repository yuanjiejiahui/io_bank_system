package com.baizhi.view;

import com.baizhi.controller.UserUtils;
import com.baizhi.entity.Users;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ShowUserView extends JPanel implements MouseListener {
    private JPanel top,bom;
    private JLabel telJL,pwdJL,nameJL,relNameJL,cardNumJL,emailJL,moneyJL;
    private JTextField telJF,nameJF,relNameJF,cardNumJF,emailJF,moneyJF;
    private JPasswordField pwdJF;
    private JButton change;
    public ShowUserView(Users u){
        this.setLayout(new BorderLayout());
        top = new JPanel();
        JLabel topJl = new JLabel("个人信息展示");
        top.add(topJl);
        this.add(top,BorderLayout.NORTH);

        bom = new JPanel();
            bom.setLayout(new GridLayout(9,2,10,10));

        EmptyBorder jbo = new EmptyBorder(6,70,0,0);
        EmptyBorder fbo = new EmptyBorder(6,0,0,-52);

        telJL = new JLabel("手机号:",JLabel.CENTER);
        telJL.setIcon(new ImageIcon("img/phone_icon.png"));
        telJL.setBorder(jbo);
        telJF = new JTextField(20);
        telJF.setText(u.getTel());
        telJF.setBorder(fbo);
        telJF.setEditable(false);
        bom.add(telJL);
        bom.add(telJF);

        pwdJL = new JLabel("密 码:",JLabel.CENTER);
        pwdJL.setIcon(new ImageIcon("img/password_icon.png"));
        pwdJL.setBorder(jbo);
        pwdJF = new JPasswordField(20);
        pwdJF.setText(u.getPwd());
        pwdJF.setBorder(fbo);
        pwdJF.setEditable(false);
        bom.add(pwdJL);
        bom.add(pwdJF);

        nameJL = new JLabel("昵称:",JLabel.CENTER);
        nameJL.setIcon(new ImageIcon("img/name_icon.png"));
        nameJL.setBorder(jbo);
        nameJF= new JTextField(20);
        nameJF.setText(u.getPwd());
        nameJF.setBorder(fbo);
        nameJF.setEditable(false);
        bom.add(nameJL);
        bom.add(nameJF);

        relNameJL = new JLabel("真实姓名:",JLabel.CENTER);
        relNameJL.setIcon(new ImageIcon("img/username_icon.png"));
        relNameJL.setBorder(jbo);
        relNameJF = new JTextField(20);
        relNameJF.setText(u.getRelName());
        relNameJF.setBorder(fbo);
        relNameJF.setEditable(false);
        bom.add(relNameJL);
        bom.add(relNameJF);

        cardNumJL = new JLabel("身份证:",JLabel.CENTER);
        cardNumJL.setIcon(new ImageIcon("img/idc_icon.png"));
        cardNumJL.setBorder(jbo);
        cardNumJF = new JTextField(20);
        cardNumJF.setText(u.getCardNum());
        cardNumJF.setBorder(fbo);
        cardNumJF.setEditable(false);
        bom.add(cardNumJL);
        bom.add(cardNumJF);

        emailJL = new JLabel("邮箱:",JLabel.CENTER);
        emailJL.setIcon(new ImageIcon("img/msg_icon.png"));
        emailJL.setBorder(jbo);
        emailJF = new JTextField(20);
        emailJF.setText(u.getEmail());
        emailJF.setBorder(fbo);
        emailJF.setEditable(false);
        bom.add(emailJL);
        bom.add(emailJF);


        moneyJL = new JLabel("余额:",JLabel.CENTER);
        moneyJL.setIcon(new ImageIcon("img/dialog_ok_icon.png"));
        moneyJL.setBorder(jbo);
        moneyJF = new JTextField(20);
        String money = String.valueOf(u.getMoney());
        moneyJF.setText(money);
        moneyJF.setBorder(fbo);
        bom.add(moneyJL);
        bom.add(moneyJF);


        change =new JButton("刷新");
        change.addMouseListener(this);
        bom.add(change);

        this.add(bom,BorderLayout.CENTER);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
            moneyJF.setText(String.valueOf(UserUtils.getUsers().getMoney()));

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
