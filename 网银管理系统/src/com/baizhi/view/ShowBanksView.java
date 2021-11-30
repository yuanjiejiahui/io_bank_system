package com.baizhi.view;

import com.baizhi.entity.Banks;

import javax.swing.*;
import java.util.List;

public class ShowBanksView extends JPanel  {

    List<Banks> list;
    public ShowBanksView(List<Banks> list){
        this.list = list;
        JScrollPane js = new JScrollPane();
        Object[] clum ={"卡号","开户行","余额"};
        Object[][] data = new  Object[list.size()][3];
        for (int i=0;i<list.size();i++){
            Banks b = list.get(i);
            data[i][0] = b.getBankNum();
            data[i][1] = b.getBankName();
            data[i][2] = b.getMoney();

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
