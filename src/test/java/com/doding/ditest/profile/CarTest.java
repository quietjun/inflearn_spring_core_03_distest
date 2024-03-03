package com.doding.ditest.profile;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.doding.ditest.cars.Car;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@ActiveProfiles({ "dev", "oper" })
@Slf4j
public class CarTest {
    @Autowired(required = false)
    @Qualifier("carForLife")
    Car car;

    @Test
    public void carTest() {
        // assertNull(car);
        assertNotNull(car);
        log.debug("car type: {}", car.getClass().getName());
    }
}
