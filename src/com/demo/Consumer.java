package com.demo;

import java.io.Serializable;

public interface Consumer extends Serializable {
    String getName();

    Integer getPower();

    void morePower(int amount) throws NotAPowerGeneratorException;
}
