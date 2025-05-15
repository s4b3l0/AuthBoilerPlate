package app.poc.secure.demo.repo;

import app.poc.secure.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsDistinctByUsernameAndPassword(String username, String password);
    Optional<User> findDistinctByUsername(String username);
}
