package uk.cf.ac.nccteam11.account.repository;

import uk.cf.ac.nccteam11.account.domain.User;

import java.util.List;

public interface UserRepository {
    List<User> getUsers();

    void addUser(User newUser);
}
