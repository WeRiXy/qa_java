package com.example;

import java.util.List;

public class Lion {

    boolean hasMane;
    Family family;

    public Lion(Feline feline, String sex) throws Exception {
        this.family=feline;
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самей или самка");
        }
    }


    public int getKittens() {
        return family.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return family.getFood("Хищник");
    }
}
