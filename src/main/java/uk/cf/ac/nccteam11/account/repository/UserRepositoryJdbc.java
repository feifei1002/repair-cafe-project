package uk.cf.ac.nccteam11.account.repository;

import org.springframework.data.repository.CrudRepository;
import uk.cf.ac.nccteam11.account.domain.User;

public interface UserRepositoryJdbc extends CrudRepository<User, Integer> {
}
