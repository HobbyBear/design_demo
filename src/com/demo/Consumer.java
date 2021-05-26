package com.demo;

public interface Consumer {
    String getName();

    Integer getPower();

    void morePower(int amount) throws NotAPowerGeneratorException;
}
