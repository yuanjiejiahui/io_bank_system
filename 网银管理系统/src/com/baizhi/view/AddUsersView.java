package com.baizhi.view;

import com.baizhi.controller.UsersController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AddUsersView extends JDialog implements MouseListener {
    private JPanel jp;

    private JLabel telJL,pwdJL,nameJL,relNameJL,cardNumJL,emailJL;
    private JTextField telJF,nameJF,relNameJF,cardNumJF,emailJF;
    private JPasswordField pwdJF;
    private JButton sub,clo;
    public AddUsersView(Frame owner){
        super(owner);
        jp = new JPanel();
        jp.setBackground(Color.GRAY);
        jp.setBorder(new EmptyBorder(20,20,20,20));
        jp.setLayout(new GridLayout(7,2,20,20));
        EmptyBorder jbo = new EmptyBorder(0,20,0,0);
        EmptyBorder fbo = new EmptyBorder(10,0,10,20);

        telJL = new JLabel("手机号",JLabel.LEFT);
        telJL.setIcon(new ImageIcon("img/phone_icon.png"));
        telJL.setBorder(jbo);
        telJF = new JTextField(20);

        telJF.setBorder(fbo);
        jp.add(telJL);
        jp.add(telJF);

        pwdJL = new JLabel("密 码",JLabel.LEFT);
        pwdJL.setIcon(new ImageIcon("img/password_icon.png"));
        pwdJL.setBorder(jbo);
        pwdJF = new JPasswordField(20);
        pwdJF.setBorder(fbo);
        jp.add(pwdJL);
        jp.add(pwdJF);

        nameJL = new JLabel("昵称",JLabel.LEFT);
        nameJL.setIcon(new ImageIcon("img/name_icon.png"));
        nameJL.setBorder(jbo);
        nameJF= new JTextField(20);
        nameJF.setBorder(fbo);
        jp.add(nameJL);
        jp.add(nameJF);

        relNameJL = new JLabel("真实姓名",JLabel.LEFT);
        relNameJL.setIcon(new ImageIcon("img/username_icon.png"));
        relNameJL.setBorder(jbo);
        relNameJF = new JTextField(20);
        relNameJF.setBorder(fbo);
        jp.add(relNameJL);
        jp.add(relNameJF);

        cardNumJL = new JLabel("身份证：",JLabel.LEFT);
        cardNumJL.setIcon(new ImageIcon("img/idc_icon.png"));
        cardNumJL.setBorder(jbo);
        cardNumJF = new JTextField(20);
        cardNumJF.setBorder(fbo);
        jp.add(cardNumJL);
        jp.add(cardNumJF);

        emailJL = new JLabel("邮箱",JLabel.LEFT);
        emailJL.setIcon(new ImageIcon("img/msg_icon.png"));
        emailJL.setBorder(jbo);
        emailJF = new JTextField(20);
        emailJF.setBorder(fbo);
        jp.add(emailJL);
        jp.add(emailJF);

        sub =new JButton("提交");
        sub.setName("sub");
        sub.addMouseListener(this);
        jp.add(sub);

        clo =new JButton("取消");
        clo.setName("clo");
        clo.addMouseListener(this);
        jp.add(clo);

        this.add(jp);
        this.setTitle("百知转账管理系统---->用户注册！");//标题
        this.setSize(400, 500);//大小
        this.setLocationRelativeTo(null);//居中
        this.setResizable(false);//不允许改变文件大小
        this.setVisible(true);//显示
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String str = e.getComponent().getName();
        switch (str) {
            case "sub":
                String tel = telJF.getText();
                String pwd = new String(pwdJF.getPassword());
                String name =nameJF.getText();
                String relName = relNameJF.getText();
                String cardNum =cardNumJF.getText();
                String email = emailJF.getText();
                if (tel.equals("")) {
                    JOptionPane.showMessageDialog(null,"手机号不能为空！");
                    break;
                }
                if (pwd.equals("")) {
                    JOptionPane.showMessageDialog(null,"密码不能为空！");
                    break;
                }
                if (name.equals("")) {
                    JOptionPane.showMessageDialog(null,"昵称不能为空！");
                    break;
                }
                if (relName.equals("")) {
                    JOptionPane.showMessageDialog(null,"真实姓名不能为空！");
                    break;
                }
                if (cardNum.equals("")) {
                    JOptionPane.showMessageDialog(null,"身份证不能为空！");
                    break;
                }
                if (email.equals("")) {
                    JOptionPane.showMessageDialog(null,"邮箱不能为空！");
                    break;
                }
                UsersController con = new UsersController();
                if(con.isExistTel(tel)){
                    JOptionPane.showMessageDialog(null,"手机号已注册！");
                    break;
                }
                if (con.isExistEmail(email)){
                    JOptionPane.showMessageDialog(null,"邮箱已注册！");
                    break;
                }
                boolean flag = con.addUsers(tel,pwd,name,relName,cardNum,email);
                if(flag){
                    JOptionPane.showMessageDialog(null,"注册成功");
                }else {
                    JOptionPane.showMessageDialog(null,"注册失败！");
                }
                break;
            case "clo":
                dispose();
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
