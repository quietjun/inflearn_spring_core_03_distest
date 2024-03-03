package com.doding.ditest.heroes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class BootHeroesTest {
    @Autowired
    Avengers avenger;

    @Test
    public void avengerTest() {
        assertNotNull(avenger);
        log.debug(avenger.iman.getClass().getName());
    }

    @Autowired
    @Qualifier("hb")
    IronMan iman; // ironman 타입은 2개!!

    @Test
    public void imanTest() {
        assertNotNull(iman);
        assertEquals(iman.getClass(), HulkBuster.class);
    }

    @Resource(name = "hb")
    public IronMan ironManByName;

    @Test
    public void resourceTest() {
        assertNotNull(ironManByName);
        assertSame(iman, ironManByName);
    }
}
