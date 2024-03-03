package com.doding.ditest.phone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class BootPhoneTest {
    @Autowired
    ApplicationContext ctx; // IOC Container

    @Test
    @DisplayName("phone이 들어간 빈의 이름들을 모두 출력해보자.")
    public void printBeanNames() {
        Arrays.stream(ctx.getBeanDefinitionNames())
                .filter(name -> name.matches("(?i).*phone.*")) // 대소문자 구분 없이 phone이 들어간 문자열
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("Spring은 빈은 타입 기반으로 관리하며 기본적으로 singleton이다.")
    public void usePhoneTest() {
        SPhone phone1 = ctx.getBean(SPhone.class);
        SPhone phone2 = ctx.getBean(SPhone.class);
        assertSame(phone1, phone2);

        SmartPhone phone3 = ctx.getBean(PhoneUser.class).phone;
        assertSame(phone2, phone3);
    }

    @Test
    @DisplayName("동일 타입의 빈이 2개 이상 있을 경우는 이름 기반의 접근 방법을 추가 필요")
    public void getPhoneTestByType() {
        // 동일 타입의 빈이 2개 이상 있을 때 예외 발생
        assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ctx.getBean(SmartPhone.class));

        // 이름 기반의 빈 요청
        SmartPhone phone = ctx.getBean("sPhone", SmartPhone.class);
        assertEquals(phone.getClass().getName(), SPhone.class.getName());
    }
}
