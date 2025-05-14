package app.poc.secure.demo.jwtutil;

import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TokenGeneratorTest {

    private static final JwtTokenUtil<String, String> tokenGenerator = new TokenGenerator();

    @BeforeAll()
    static void beforeAll() {
        ReflectionTestUtils.setField(tokenGenerator, "jwtExpiration", 3900000);
        ReflectionTestUtils.setField(tokenGenerator, "secretKey", Keys.hmacShaKeyFor("301142d939159e0448d4c85c0590de3285fe401aecff52c398a1499ddef00a7f".getBytes(StandardCharsets.UTF_8)));
    }

    @Test
    void process() {
        //Generate the needed token


        final String username = "John";
        final String token = tokenGenerator.process(username);

        assertNotNull(token);
        assertFalse(token.isEmpty());
    }
}