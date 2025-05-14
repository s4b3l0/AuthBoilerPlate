package app.poc.secure.demo.jwtutil;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class TokenGenerator implements WorkProcessor<String, String> {

    @Value("${jwt.secret}")
    private String jwtSecret;
    @Value("${jwt.expiration}")
    private Integer jwtExpiration;
    private SecretKey secretKey;


    @PostConstruct
    public void init() {
        this.secretKey = Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public String process(String username) {
        var startDate = new Date();
        var expirationDate = new Date(new Date().getTime() + jwtExpiration);

        var token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(startDate)
                .setExpiration(expirationDate)
                .signWith(secretKey)
                .compact();

        return token;
    }
}
