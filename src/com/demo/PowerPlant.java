package com.demo;

public class PowerPlant extends Building {
    public PowerPlant(String name, int power) {
        super(name, power);
    }

    @Override
    public void morePower(int amount) {
        setPower(getPower() - amount);
    }
}
