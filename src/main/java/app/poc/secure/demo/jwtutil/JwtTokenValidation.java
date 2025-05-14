package app.poc.secure.demo.jwtutil;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public final class JwtTokenValidation extends JwtTokenUtil<Boolean, String> {

    @Override
    public Boolean process(String input) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(input);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
