package com.cmz.study.pattern.factory.factorymethod;

public class FruitFactory {

    public Fruit createApple() {
        return new Apple();
    }

    public Fruit createBanana() {
        return new Banana();
    }

}
