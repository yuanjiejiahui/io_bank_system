package com.baizhi.view;

import com.baizhi.controller.BanksController;
import com.baizhi.entity.Banks;
import com.baizhi.entity.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AddBanksView extends JPanel implements MouseListener {


    private JPanel top, bom;
    private JLabel bankNumJL, MoneyJL, bankNameJL;
    private JTextField bankNumJF, MoneyJF, bankNameJF;
    private JButton sub;
    private Users users;

    public AddBanksView(Users users) {
        this.users = users;
        this.setLayout(new BorderLayout());
        top = new JPanel();
        top.setLayout(new GridLayout(3, 2, 20, 20));
        this.add(top, BorderLayout.NORTH);

        bankNumJL = new JLabel("卡号", JLabel.CENTER);
        bankNumJF = new JTextField(20);
        top.add(bankNumJL);
        top.add(bankNumJF);


        bankNameJL = new JLabel("开户行", JLabel.CENTER);
        bankNameJF = new JTextField(20);
        top.add(bankNameJL);
        top.add(bankNameJF);


        MoneyJL = new JLabel("余额", JLabel.CENTER);
        MoneyJF = new JTextField(20);
        top.add(MoneyJL);
        top.add(MoneyJF);
        this.add(top, BorderLayout.CENTER);


        bom = new JPanel();
        sub = new JButton("提交");
        sub.setName("sub");
        sub.addMouseListener(this);
        bom.add(sub);
        this.add(bom, BorderLayout.SOUTH);


    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String bankNum = bankNumJF.getText();
        String money = MoneyJF.getText();
        String bankName = bankNameJF.getText();
        if (bankNum.equals("")) {
            JOptionPane.showMessageDialog(null, "卡号不能为空！");
        }
        if (money.equals("")) {
            JOptionPane.showMessageDialog(null, "余额不能为空！！");
        }
        if (bankName.equals("")) {
            JOptionPane.showMessageDialog(null, "开户行不能为空！");
        }
        Double mo = Double.parseDouble(money);
        BanksController b = new BanksController();
        Banks banks = new Banks(bankNum,mo,bankName,users.getTel());
        boolean flag = b.addBanks(banks);
        if(flag){
            JOptionPane.showMessageDialog(null, "添加成功！");
        }else {
            JOptionPane.showMessageDialog(null, "添加失败！");
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
