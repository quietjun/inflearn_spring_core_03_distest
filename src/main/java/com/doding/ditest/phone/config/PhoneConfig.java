package com.doding.ditest.phone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.doding.ditest.phone.LPhone;
import com.doding.ditest.phone.PhoneUser;
import com.doding.ditest.phone.SPhone;
import com.doding.ditest.phone.SmartPhone;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class PhoneConfig {
    @Bean // 명시적인 빈 생성
    public SPhone sPhone() { // 기본적인 빈의 이름을 메서드의 이름
        log.debug("sphone 생성");
        return new SPhone();
    }

    @Bean(name = "mylPhone") // 빈의 이름을 변경하려는 경우 name 속성 활용
    public LPhone lPhone() {
        log.debug("lphone 생성");
        return new LPhone();
    }

    @Bean
    public PhoneUser phoneUser() {
        log.debug("phoneuser 생성");
        SmartPhone phone = sPhone();
        return new PhoneUser(phone); // SPhone 타입의 빈을 생성자를 통해서 주입 받음
    }
}
