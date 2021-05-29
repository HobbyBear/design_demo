package com.demo;

import javax.swing.*;
import java.awt.*;

public abstract class View<T extends Controller> extends JFrame implements ModelListener {

    protected ElectricityCompany m;
    protected T c;


    public View(ElectricityCompany m, T c) throws HeadlessException {
        this.m = m;
        this.c = c;
        m.addListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    @Override
    public abstract void update();
}
