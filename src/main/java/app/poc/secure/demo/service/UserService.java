package app.poc.secure.demo.service;

import app.poc.secure.demo.entity.User;
import app.poc.secure.demo.repo.UserRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @SneakyThrows
    public User save(User user) {
        //checking if username already registered in the db
        var userOptional = userRepository.findDistinctByUsername(user.getUsername());

        if (userOptional.isPresent()) {
            log.warn("User {} already exists", user.getUsername());
            return null;
        }

        log.info("Creating user {}", user.getUsername());
        return userRepository.save(user);
    }

    @SneakyThrows
    public Boolean grantUserAccess(String username, String password) {
        return userRepository.existsDistinctByUsernameAndPassword(username, password);
    }

    @SneakyThrows
    public Boolean changePassword(String username, String newPassword) {
        var userOptional = userRepository.findDistinctByUsername(username);

        if (userOptional.isPresent()) {
            var user = userOptional.get();
            user.setPassword(newPassword);
            return userRepository.save(user) != null;
        }

        return false;
    }


}
