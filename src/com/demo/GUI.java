package com.demo;

import java.io.IOException;

public class GUI {
    public static void main(String[] args) throws NotAPowerGeneratorException, UnknownConsumerException, IOException, ClassNotFoundException {
        ElectricityCompany electricityCompany = new ElectricityCompany("UIC");
        electricityCompany.addConsumer(new PowerPlant("power plant",-2000));
        electricityCompany.addConsumer(new House("house",2500));
        electricityCompany.addConsumer(new SolarHouse("solar",500));
        electricityCompany.morePower("solar",-2000);
        ControllerGetPower c = new ControllerGetPower(electricityCompany);
        ViewHistory viewSimple = new ViewHistory(electricityCompany,c);
        viewSimple.setSize(300,400);
        viewSimple.setVisible(true);
    }
}
