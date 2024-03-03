package com.doding.ditest.coffee;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
@Scope("singleton") // 기본 scope: 생략 가능
public class CoffeeShop {
    // private final Barista barista; // CoffeeShop에는 반드시 필요: 의존성
    private final ObjectProvider<Barista> baristaProvider;

    public Coffee orderCoffee(String client, String name) {
        System.out.println("coffee 주문: " + name);
        // Coffee coffee = barista.makeCoffee(name);
        Coffee coffee = baristaProvider.getObject().makeCoffee(name);
        coffee.setClient(client);
        coffee.cleanup();// prototype 빈의 소멸 메서드 호출은 직접 처리!
        return coffee;
    }

    @PostConstruct
    public void setup() {
        System.out.println("coffeeshop에서 필요한 집기를 준비한다.");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("coffeeshop 집기들을 정리한다.");
    }
}
