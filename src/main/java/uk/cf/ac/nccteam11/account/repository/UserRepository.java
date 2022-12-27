package uk.cf.ac.nccteam11.account.repository;

import uk.cf.ac.nccteam11.account.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> getUsers();

    void addUser(User newUser);
    Optional<User> getUserById(Integer id);
    void deleteUserById(User user);
}
