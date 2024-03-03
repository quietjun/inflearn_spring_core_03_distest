package com.doding.ditest;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication // 내부적으로 @Configuration을 가지고 있음
public class DitestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DitestApplication.class, args);
	}

	@Autowired
	private ApplicationContext ctx;

	@Bean
	public CommandLineRunner cRunner() {
		return args -> {
			System.out.println("args: " + Arrays.toString(args));
			int beanCnt = ctx.getBeanDefinitionCount();
			System.out.println("생성된 빈의 개수: " + beanCnt);
		};
	}
}
