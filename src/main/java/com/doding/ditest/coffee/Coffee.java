package com.doding.ditest.coffee;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import lombok.Data;

@Component // 라이프 사이클은 Spring Container가 관리!! --> 직접 new 금지!!
@Data
@Scope("prototype")
public class Coffee {
    private String client; // 상태를 갖는다.
    private String name;

    public Coffee(String name) {
        this.name = name;
        System.out.println(name + "커피 완성!");
    }

    @PostConstruct
    public void setup() {
        System.out.println("고객에게 커피 배달");
    }

    // prototype 빈은 객체 생성, 의존성 주입, post construct까지만 container가 관리
    public void cleanup() {
        System.out.println("다 마신 커피잔은 설겆이");
    }
}
