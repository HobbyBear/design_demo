package com.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewCreate extends View{

    private JTextField t1;

    private JTextField t2;

    private JComboBox<String> jComboBox;

    public ViewCreate(ElectricityCompany m, ControllerCreate c) throws HeadlessException {
        super(m, c);
        t1 = new JTextField("Type a consumer name here");
        t2 = new JTextField("Type the amount of power  here");
        jComboBox = new JComboBox<>();
        jComboBox.addItem("Power Plant");
        jComboBox.addItem("House");
        jComboBox.addItem("Solar House");

        GridLayout gridLayout = new GridLayout();
        gridLayout.setRows(3);
        gridLayout.setColumns(1);
        this.setLayout(gridLayout);
        this.add(t1);
        this.add(t2);
        this.add(jComboBox);
        JButton button = new JButton("Create");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String msg =c.create(t1.getText(),t2.getText(),jComboBox.getSelectedIndex() + 1);
                    if (!msg.equals("")){
                        JOptionPane.showMessageDialog(null,msg);
                    }else {
                        JOptionPane.showMessageDialog(null,"success");
                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null,exception.getMessage());
                }
            }
        });
        this.add(button);
    }


    @Override
    public void update() {

    }
}
