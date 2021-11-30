package com.baizhi.view;

import com.baizhi.entity.Banks;
import com.baizhi.entity.Users;

import javax.swing.*;
import java.util.List;

public class ManageUserView extends JPanel {
    public ManageUserView(List<Users> list){
        JScrollPane js = new JScrollPane();
        Object[] clum ={"昵称","真实姓名","手机号"};
        Object[][] data = new  Object[list.size()][3];
        for (int i=0;i<list.size();i++){
            Users b = list.get(i);
            data[i][0] = b.getName();
            data[i][1] = b.getRelName();
            data[i][2] = b.getTel();

        }

        JTable jTable = new JTable(data,clum){
            public boolean isCellEditable(int row, int column) {
                return false;
            }//表格不允许被编辑
        };
        js.setViewportView(jTable);
        this.add(js);
}
}
