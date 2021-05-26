package com.demo;

public class House extends Building {


    public House(String name, int power) throws NotAPowerGeneratorException {
        super(name, power);
        if (power < 0) {
            throw new NotAPowerGeneratorException("A new house cannot generate power");
        }
    }

    @Override
    public void morePower(int amount) throws NotAPowerGeneratorException {
        if ((getPower() + amount) < 0) {
            throw new NotAPowerGeneratorException("A house cannot generate " + (-getPower() - amount) + " watts of power");
        }
        this.setPower(getPower() + amount);
    }
}
