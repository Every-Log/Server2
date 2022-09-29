package tteokbokki.everylog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tteokbokki.everylog.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

}
