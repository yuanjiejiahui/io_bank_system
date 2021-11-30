package com.baizhi.view;


import com.baizhi.controller.BanksController;
import com.baizhi.entity.Banks;
import com.baizhi.entity.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;


public class MoveMoneyView extends JPanel implements MouseListener {
    private JPanel top, bom;
    private JLabel moneyJL, banksNumJL,moveJL;
    private JTextField moneyJF,moveJF;
    private JComboBox banksNUmJB;

    private JButton sub;
    private Users users;
    public MoveMoneyView(Users users, List<Banks> list) {
        this.users = users;
        this.setLayout(new BorderLayout());
        top = new JPanel();
        top.setLayout(new GridLayout(3, 2, 20, 20));
        this.add(top, BorderLayout.NORTH);



        banksNumJL = new JLabel("请选择转账（账号）", JLabel.CENTER);
        banksNUmJB = new JComboBox();
        banksNUmJB.addItem("--请选择--");
        for(Banks b :list){
            banksNUmJB.addItem(b.getBankNum());
        }
        top.add(banksNumJL);
        top.add(banksNUmJB);
        this.add(top, BorderLayout.CENTER);

        moveJL = new JLabel("转账金额", JLabel.CENTER);
        moveJF = new JTextField(20);
        top.add(moveJL);
        top.add(moveJF);


        moneyJL = new JLabel("对方账号", JLabel.CENTER);
        moneyJF = new JTextField(20);
        top.add(moneyJL);
        top.add(moneyJF);

        bom = new JPanel();
        sub = new JButton("转账");
        sub.addMouseListener(this);
        bom.add(sub);
        this.add(bom, BorderLayout.SOUTH);
    }
    @Override
    public void mouseClicked(MouseEvent e) {

        String bankNum = banksNUmJB.getSelectedItem().toString();//选择转账对象
        String move = moveJF.getText();//转账金额
        String money = moneyJF.getText();//转账账号

        if ("--请选择--".equals(bankNum)) {
            JOptionPane.showMessageDialog(null, "请选择银行卡！！");
            return;
        }
        if (move.equals("")) {
            JOptionPane.showMessageDialog(null, "转账金额不能为空！");
            return;
        }
        if (money.equals("")) {
            JOptionPane.showMessageDialog(null, "转账账号不能为空！");
            return;
        }
        try{
            Double m_ove = Double.parseDouble(move);
            if(m_ove<=0){
                JOptionPane.showMessageDialog(null, "转账金额不能小于零！！");
                return;
            }
        }catch (Exception e1){
            JOptionPane.showMessageDialog(null, "请输入数字！！");
            return;
        }
        Double m_ove = Double.parseDouble(move);
        BanksController banksContorller = new BanksController();
        boolean flag = banksContorller.deleteMoney(bankNum,m_ove);//余额扣款
        if(flag){
            banksContorller.addMoney(money,m_ove);
            JOptionPane.showMessageDialog(null, "转账成功！");
        }else {
            JOptionPane.showMessageDialog(null, "银行卡余额不足，请更换银行卡");
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
