package com.baizhi.view;

import com.baizhi.controller.BanksController;
import com.baizhi.controller.ManageController;
import com.baizhi.controller.UserUtils;
import com.baizhi.entity.Banks;
import com.baizhi.entity.Users;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class MainView extends JFrame implements MouseListener {
    private JPanel jpJP, topJp, leftJP, conJP, indexJP;
    private JLabel logoJL, welJL, indexJL;
    private JButton indexJB, showUserJB, pwdJB, banksJB,addbanksJB, addMoneyJB, deleteMoneyJB, moveMoneyJB, updateUserJB;


    private Users users;

    public MainView(Users users) {
        jpJP = new JPanel();
        jpJP.setLayout(new BorderLayout());

        topJp = new JPanel();
        logoJL = new JLabel();
        ImageIcon lo = new ImageIcon("img/logo.png");
        lo.setImage(lo.getImage().getScaledInstance(200, 30, Image.SCALE_DEFAULT));
        logoJL.setIcon(lo);
        welJL = new JLabel("欢迎用户" + users.getName());
        System.out.println();

        topJp.add(logoJL);
        topJp.add(welJL);
        jpJP.add(topJp, BorderLayout.NORTH);
        leftJP = new JPanel();
        leftJP.setLayout(new GridLayout(9, 1, 20, 20));
        EmptyBorder jb = new EmptyBorder(10, 0, 10, 20);
        indexJB = new JButton("首页");
        indexJB.setName("indexJB");
        indexJB.setBorder(jb);
        indexJB.addMouseListener(this);
        leftJP.add(indexJB);

        showUserJB = new JButton("用户信息");
        showUserJB.setName("showUserJB");
        showUserJB.setBorder(jb);
        showUserJB.addMouseListener(this);
        leftJP.add(showUserJB);

        pwdJB = new JButton("修改密码");
        pwdJB.setName("pwdJB");
        pwdJB.setBorder(jb);
        pwdJB.addMouseListener(this);
        leftJP.add(pwdJB);

        banksJB = new JButton("银行卡");
        banksJB.setName("banksJB");
        banksJB.setBorder(jb);
        banksJB.addMouseListener(this);
        leftJP.add(banksJB);

        addbanksJB = new JButton("添加银行卡");
        addbanksJB.setName("addbanksJB");
        addbanksJB.setBorder(jb);
        addbanksJB.addMouseListener(this);
        leftJP.add(addbanksJB);

        addMoneyJB = new JButton("充值");
        addMoneyJB.setName("addMoneyJB");
        addMoneyJB.setBorder(jb);
        addMoneyJB.addMouseListener(this);
        leftJP.add(addMoneyJB);

        deleteMoneyJB = new JButton("提现");
        deleteMoneyJB.setName("deleteMoneyJB");
        deleteMoneyJB.setBorder(jb);
        deleteMoneyJB.addMouseListener(this);
        leftJP.add(deleteMoneyJB);

        moveMoneyJB = new JButton("转账");
        moveMoneyJB.setName("moveMoneyJB");
        moveMoneyJB.setBorder(jb);
        moveMoneyJB.addMouseListener(this);
        leftJP.add(moveMoneyJB);

        updateUserJB = new JButton("管理用户");
        updateUserJB.setName("updateUserJB");
        updateUserJB.setBorder(jb);
        updateUserJB.addMouseListener(this);
        leftJP.add(updateUserJB);
        jpJP.add(leftJP, BorderLayout.WEST);

        conJP = new JPanel();
        conJP.setBorder(new EmptyBorder(10, 10, 10, 0));
        indexJP = new JPanel();
        indexJP.setSize(400, 450);
        indexJL = new JLabel();
        ImageIcon icon = new ImageIcon("img/banner1.jpg");
        indexJL.setIcon(icon);

        indexJP.add(indexJL);
        conJP.add(indexJP);
        jpJP.add(conJP);
        this.add(jpJP);
        this.users = users;
        this.setSize(600, 500);
        UserUtils.setClose(this);
        this.setLocationRelativeTo(null);//居中
        this.setResizable(false);//不允许改变文件大小
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭方式
        this.setVisible(true);//显示
    }

    public void updateView(JPanel jp){
        conJP.removeAll();
        conJP.add(jp);
        conJP.validate();
        conJP.updateUI();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String str = e.getComponent().getName();
        switch (str) {
            case "indexJB":
                updateView(indexJP);
                break;
            case "showUserJB":
                ShowUserView showUserView = new ShowUserView(users);
                updateView(showUserView);
                break;
            case "pwdJB":
                UpdatePwdView updatePwdView = new UpdatePwdView(users);
                updateView(updatePwdView);
                break;
            case "banksJB":
                BanksController banksContorller = new BanksController();
                List<Banks> list = banksContorller.showBanksByTel(users.getTel())   ;
                ShowBanksView showBanksView = new ShowBanksView(list);
                updateView(showBanksView);
                System.out.println("银行");
                break;

            case "addbanksJB":
                System.out.println("添加银行");
                AddBanksView addBanksView = new AddBanksView(users);
                updateView(addBanksView);
                break;
            case "addMoneyJB":
                System.out.println("充值");
                BanksController banksContorller1 = new BanksController();
                List<Banks> list1 = banksContorller1.showBanksByTel(users.getTel());
                AddMoneyView addUsersView = new AddMoneyView(users,list1);
                updateView(addUsersView);
                break;
            case "deleteMoneyJB":
                BanksController tixian = new BanksController();
                List<Banks> list2 = tixian.showBanksByTel(users.getTel());
                UpMoneyView withDrawView = new UpMoneyView(users,list2);
                updateView(withDrawView);
                System.out.println("提现");

                break;
            case "moveMoneyJB":
                BanksController zhuanZ = new BanksController();
                List<Banks> list3 = zhuanZ.showBanksByTel(users.getTel());
                MoveMoneyView  moveMoneyView = new MoveMoneyView(users,list3);
                updateView(moveMoneyView);
                System.out.println("转账");
                break;
            case "updateUserJB":
                ManageController manageController = new ManageController();
                List<Users> list5 = manageController.showBanksByTel(users.getTel())   ;
                ManageUserView manageUserView = new ManageUserView(list5);
                updateView(manageUserView);
                System.out.println("管理用户");
                break;
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
