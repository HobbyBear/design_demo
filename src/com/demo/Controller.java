package com.demo;

import java.io.IOException;

public class Controller {

    ElectricityCompany m;

    public Controller(ElectricityCompany m) {
        this.m = m;
    }


    protected void shutDown() throws IOException {
        m.saveData();
        System.exit(0);
    }
}
