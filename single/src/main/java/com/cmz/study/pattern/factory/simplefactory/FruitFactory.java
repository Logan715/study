package com.cmz.study.pattern.factory.simplefactory;

public class FruitFactory {

    public Fruit createFruit(FruitType type) {
        switch (type) {
            case APPLE:
                return new Apple();
            case BANABA:
                return new Banana();
            default:
                throw new RuntimeException("not defined the fruit type");
        }
    }
}
