package app.poc.secure.demo.jwtutil;

import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class JwtTokenUtilTest {

    private final String userName = new String("Sabelo");
    private final JwtTokenUtil<String, String> jwtTokenUtil = new TokenGenerator();
    private String token;

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(jwtTokenUtil, "jwtExpiration", 100_000 * 10);
        ReflectionTestUtils.setField(jwtTokenUtil, "key", Keys.hmacShaKeyFor("301142d939159e0448d4c85c0590de3285fe401aecff52c398a1499ddef00a7f".getBytes(StandardCharsets.UTF_8)));
        token = jwtTokenUtil.process(userName);
    }

    @Test()
    void userNameFromToken_Test() {
        String actualUsername = jwtTokenUtil.getUserNameFromJwtToken(token);

        assertNotNull(actualUsername);
        assertEquals(userName, actualUsername);
    }
}