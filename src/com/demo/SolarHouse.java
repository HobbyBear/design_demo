package com.demo;

public class SolarHouse extends Building{

    public SolarHouse(String name, int power) {
        super(name, power);
    }

    @Override
    public void morePower(int amount)  {
        this.setPower(getPower() + amount);
    }
}
