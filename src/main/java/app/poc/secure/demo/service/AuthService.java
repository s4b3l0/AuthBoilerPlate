package app.poc.secure.demo.service;


import app.poc.secure.demo.entity.User;
import app.poc.secure.demo.jwtutil.JwtTokenUtil;
import app.poc.secure.demo.repo.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final JwtTokenUtil<String, String> tokenGenerator;


    public AuthService(UserRepository userRepository,
                       JwtTokenUtil<String, String> tokenGenerator) {
        this.userRepository = userRepository;
        this.tokenGenerator = tokenGenerator;
    }

    private String login(User user) {
        return "";
    }
}
