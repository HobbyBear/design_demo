package com.demo;

public abstract class Building implements Consumer {

    private String name;

    private int power;


    public Building(String name, int power) {
        this.name = name;
        this.power = power;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getPower() {
        return power;
    }

    public abstract void morePower(int amount) throws NotAPowerGeneratorException;

    protected void setPower(int power) {
        this.power = power;
    }
}
