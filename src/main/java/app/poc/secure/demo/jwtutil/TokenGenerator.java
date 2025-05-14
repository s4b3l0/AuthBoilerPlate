package app.poc.secure.demo.jwtutil;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenGenerator extends JwtTokenUtil<String, String> {

    @Override
    public String process(String username) {
        var startDate = new Date();
        var expirationDate = new Date(new Date().getTime() + jwtExpiration);

        var token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(startDate)
                .setExpiration(expirationDate)
                .signWith(key) //no algo to sign
                .compact();

        return token;
    }
}
