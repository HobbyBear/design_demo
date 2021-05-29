package com.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewPower extends View{

    private JTextField t1;

    private JTextField t2;


    public ViewPower(ElectricityCompany m, ControllerMorePower c) throws HeadlessException {
        super(m, c);
        t1 = new JTextField("Type a consumer name here");
        t2 = new JTextField("Type the amount of power  here");

        GridLayout gridLayout = new GridLayout();
        gridLayout.setRows(3);
        gridLayout.setColumns(1);
        this.setLayout(gridLayout);
        this.add(t1);
        this.add(t2);
        JButton button = new JButton("More power");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    c.morePower(t1.getText(),Integer.parseInt(t2.getText()));
                    JOptionPane.showMessageDialog(null,"success");
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
