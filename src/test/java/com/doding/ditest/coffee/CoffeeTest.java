package com.doding.ditest.coffee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class CoffeeTest {
    @Autowired
    ApplicationContext ctx;

    @Test
    @DisplayName("prototype 빈과 singletype 빈의 동일성 확인")
    public void scopeTest() {
        Barista b1 = ctx.getBean(Barista.class);
        Barista b2 = ctx.getBean(Barista.class);
        assertSame(b1, b2);

        Coffee c1 = ctx.getBean(Coffee.class, "아메리카노");
        Coffee c2 = ctx.getBean(Coffee.class, "아메리카노");
        assertNotSame(c1, c2);

    }

    @Autowired
    CoffeeShop shop;

    @Test
    public void makeCoffeeTest() {
        Coffee coffee = shop.orderCoffee("hong", "latte");
        assertEquals(coffee.getName(), "latte");
        assertEquals(coffee.getClient(), "hong");
    }

    @Test
    public void coffeeShopTest() {
        assertNotNull(shop);
    }
}
