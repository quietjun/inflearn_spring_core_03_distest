package com.doding.ditest.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("oper") // default + oper
public class OperProfileTest {
    @Test
    public void dbInfoTest(
            @Value("${server.db.ip}") String ip, @Value("${server.db.user}") String user) {
        assertEquals(ip, "192.168.0.1");
        assertEquals(user, "admin");
    }

    @Test
    public void logLevelTest(@Value("${logging.level.[com.doding]}") String level) {
        assertEquals(level, "debug");
    }
}
