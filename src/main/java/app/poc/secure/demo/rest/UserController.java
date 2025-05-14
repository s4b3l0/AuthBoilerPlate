package app.poc.secure.demo.rest;

import app.poc.secure.demo.entity.User;
import app.poc.secure.demo.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/user")
public class UserController {

    private final AuthService authService;

    public UserController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return "";
    }

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        return "";
    }
}
