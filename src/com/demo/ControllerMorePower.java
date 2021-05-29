package com.demo;

public class ControllerMorePower extends Controller{

    public ControllerMorePower(ElectricityCompany m) {
        super(m);
    }

    public void morePower(String name,int power) throws UnknownConsumerException, NotAPowerGeneratorException {
        m.morePower(name,power);
    }
}
