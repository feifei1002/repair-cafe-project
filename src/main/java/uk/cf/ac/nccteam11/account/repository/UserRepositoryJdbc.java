package uk.cf.ac.nccteam11.account.repository;

import org.springframework.data.repository.CrudRepository;
import uk.cf.ac.nccteam11.account.domain.User;

import java.util.Optional;

public interface UserRepositoryJdbc extends CrudRepository<User, Integer> {
    Optional<User> findByUserId(Integer id);
}
