package com.demo;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NotAPowerGeneratorException, UnknownConsumerException {
        ElectricityCompany electricityCompany = new ElectricityCompany("UIC");
        electricityCompany.addConsumer(new PowerPlant("power plant",-2000));
        electricityCompany.addConsumer(new House("house",2500));
        electricityCompany.addConsumer(new SolarHouse("solar",500));
        electricityCompany.morePower("solar",-2000);
        electricityCompany.saveData();
        System.out.println(electricityCompany.totalConsumption());
    }
}
