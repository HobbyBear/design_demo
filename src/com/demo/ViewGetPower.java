package com.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewGetPower extends View {

    private JTextField t;

    public ViewGetPower(ElectricityCompany m, ControllerGetPower c) throws HeadlessException {
        super(m, c);
        t = new JTextField("Type a consumer name here");
        GridLayout gridLayout = new GridLayout();
        gridLayout.setRows(2);
        gridLayout.setColumns(1);
        this.setLayout(gridLayout);
        this.add(t);
        JButton button = new JButton("Tell me the power");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                   int power =  c.getPower(t.getText());
                    JOptionPane.showMessageDialog(null,power);
                } catch (UnknownConsumerException unknownConsumerException) {
                    JOptionPane.showMessageDialog(null,unknownConsumerException.getMessage());
                }
            }
        });
        this.add(button);

    }

    @Override
    public void update() {

    }
}
