package com.doding.ditest.coffee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Lazy
// @Scope("singleton")
public class Barista {
    private ApplicationContext ctx;

    public Barista(ApplicationContext ctx) {
        this.ctx = ctx;
        System.out.println("바리스타 준비 완료");
    }

    public Coffee makeCoffee(String name) {
        // return new Coffee(name); // 빈인데 직접 객체 생성?
        return ctx.getBean(Coffee.class, name); // 빈은 spring container로 부터 얻어쓴다.
    }
}
