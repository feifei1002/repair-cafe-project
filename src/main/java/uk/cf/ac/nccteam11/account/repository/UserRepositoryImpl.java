package uk.cf.ac.nccteam11.account.repository;

import org.springframework.stereotype.Repository;
import uk.cf.ac.nccteam11.account.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository{
    private final UserRepositoryJdbc userRepoJdbc;

    public UserRepositoryImpl(UserRepositoryJdbc usrRepoJdbc){
        this.userRepoJdbc = usrRepoJdbc;
    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
       userRepoJdbc.findAll().forEach(users::add);
        return users;
    }

    @Override
    public void addUser(User user){
        userRepoJdbc.save(user);
    }

    @Override
    public Optional<User> getUserById(Integer id) {
        return userRepoJdbc.findByUserId(id);
    }

    @Override
    public void deleteUserById(User user) {
        userRepoJdbc.deleteById(user.getUserId());

    }
}
