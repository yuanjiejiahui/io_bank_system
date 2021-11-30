package com.baizhi.view;

import com.baizhi.controller.BanksController;
import com.baizhi.controller.UserUtils;
import com.baizhi.controller.UsersController;
import com.baizhi.entity.Banks;
import com.baizhi.entity.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class UpMoneyView extends JPanel implements MouseListener {
    private JPanel top, bom;
    private JLabel moneyJL, banksNumJL;
    private JTextField moneyJF;
    private JComboBox banksNUmJB;

    private JButton sub;
    private Users users;
    public UpMoneyView(Users users, List<Banks> list) {
        this.users = users;
        this.setLayout(new BorderLayout());
        top = new JPanel();
        top.setLayout(new GridLayout(2, 2, 20, 20));
        this.add(top, BorderLayout.NORTH);

        moneyJL = new JLabel("提现金额", JLabel.CENTER);
        moneyJF = new JTextField(20);
        top.add(moneyJL);
        top.add(moneyJF);

        banksNumJL = new JLabel("请选择提现（账号）", JLabel.CENTER);
        banksNUmJB = new JComboBox();
        banksNUmJB.addItem("--请选择--");
        for(Banks b :list){
            banksNUmJB.addItem(b.getBankNum());
        }
        top.add(banksNumJL);
        top.add(banksNUmJB);
        this.add(top, BorderLayout.CENTER);

        bom = new JPanel();
        sub = new JButton("提现");
        sub.addMouseListener(this);
        bom.add(sub);
        this.add(bom, BorderLayout.SOUTH);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        String money = moneyJF.getText();
        String bankNum = banksNUmJB.getSelectedItem().toString();
        if (money.equals("")) {
            JOptionPane.showMessageDialog(null, "请输入提现金额！");
            return;
        }
        if ("--请选择--".equals(bankNum)) {
            JOptionPane.showMessageDialog(null, "清选择提现账号！");
            return;
        }
        try{
            Double moneys = Double.parseDouble(money);
            if(moneys<=0){
                JOptionPane.showMessageDialog(null, "提现金额不能小于零！！");
                return;
            }
        }catch (Exception e1){
            JOptionPane.showMessageDialog(null, "请输入数字！！");
            return;
        }
        Double moneys = Double.parseDouble(money);
        BanksController banksContorller = new BanksController();
        UsersController controller = new UsersController() ;
        boolean flag = banksContorller.addMoney(bankNum,moneys);//银行卡加钱
        UserUtils.setUsers(users);
        if(flag){
            controller.deleteMoney(users.getTel(),moneys);
            JOptionPane.showMessageDialog(null, "提现成功！");
        }else {
            JOptionPane.showMessageDialog(null, "银行卡余额不足，请更换银行卡！");
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
