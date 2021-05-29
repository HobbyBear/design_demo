package com.demo;

import javax.swing.*;
import java.awt.*;

public class ViewSimple  extends View implements ModelListener {


    private JLabel label;

    public ViewSimple(ElectricityCompany m,ControllerSimple c) throws HeadlessException {
        super(m,c);
        label = new JLabel("total power consumption "+String.valueOf(m.totalConsumption()));
        this.getContentPane().add(label);
    }

    @Override
    public void update() {
        label.setText(String.valueOf(m.totalConsumption()));
    }


}
