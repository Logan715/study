package com.cmz.study.pattern;

import com.cmz.study.pattern.factory.simplefactory.Fruit;
import com.cmz.study.pattern.factory.simplefactory.FruitFactory;
import com.cmz.study.pattern.factory.simplefactory.FruitType;
import org.junit.Test;

public class FactoryTest {

    @Test
    public void simpleFactory() {
        System.out.println("===== 简单工厂Demo测试 =====");
        FruitFactory factory = new FruitFactory();
        Fruit apple = factory.createFruit(FruitType.APPLE);
        Fruit banana = factory.createFruit(FruitType.BANABA);
        System.out.println(apple.describe());
        System.out.println(banana.describe());
    }

    @Test
    public void factoryMethod() {
        System.out.println("===== 工厂方法Demo测试 =====");
        com.cmz.study.pattern.factory.factorymethod.FruitFactory factory = new com.cmz.study.pattern.factory.factorymethod.FruitFactory();
        com.cmz.study.pattern.factory.factorymethod.Fruit apple = factory.createApple();
        com.cmz.study.pattern.factory.factorymethod.Fruit banana = factory.createBanana();
        System.out.println(apple.describe());
        System.out.println(banana.describe());
    }
}
