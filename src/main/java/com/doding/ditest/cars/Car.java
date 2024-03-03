package com.doding.ditest.cars;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

public interface Car {
}

@Component
@Profile("dev")
@Slf4j
class CarForExercise implements Car {
    public CarForExercise() {
        log.debug("연습용 차량 생성");
    }
}

@Component
@Profile("oper")
@Slf4j
class CarForLife implements Car {
    public CarForLife() {
        log.debug("생활용 차량 생성");
    }
}
