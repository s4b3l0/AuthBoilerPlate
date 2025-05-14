package app.poc.secure.demo.jwtutil;

import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.nio.charset.StandardCharsets;

class JwtTokenValidationTest {

    private JwtTokenUtil<Boolean, String> jwtTokenValidation;

    @BeforeEach
    void setUp() {
        jwtTokenValidation = new JwtTokenValidation();
        ReflectionTestUtils.setField(jwtTokenValidation, "key", Keys.hmacShaKeyFor("301142d939159e0448d4c85c0590de3285fe401aecff52c398a1499ddef00a7f".getBytes(StandardCharsets.UTF_8)));
    }

    @Test
    void process() {

    }
}