package com.demo;

public class ControllerGetPower extends Controller{

    public ControllerGetPower(ElectricityCompany m) {
        super(m);
    }

    public int getPower(String name) throws UnknownConsumerException {
        return  m.getPower(name);
    }
}
