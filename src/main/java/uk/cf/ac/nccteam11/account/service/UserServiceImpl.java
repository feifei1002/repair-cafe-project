package uk.cf.ac.nccteam11.account.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uk.cf.ac.nccteam11.account.domain.User;
import uk.cf.ac.nccteam11.account.repository.UserRepository;
import uk.cf.ac.nccteam11.account.service.message.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;


    public UserServiceImpl (UserRepository userRepo){
        this.userRepository = userRepo;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public UserListResponse getUsers(UserListRequest userListRequest) {
        List<UserDTO> users = getUsers();
        return UserListResponse.of()
                .request(userListRequest)
                .users(users)
                .build();
    }

    @Override
    public SaveUserResponse addNewUser(SaveUserRequest saveUserRequest) {
        UserDTO userDTO = saveUserRequest.getUserDTO();
        User newUser = new User(
                userDTO.getUserId(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail(),
                userDTO.getPhoneNo(),
                passwordEncoder.encode(userDTO.getPassword()),
                userDTO.getAddress(),
                userDTO.getCity(),
                userDTO.getPostcode(),
                userDTO.getRole(),
                userDTO.getEnabled());
        userRepository.addUser(newUser);
        return SaveUserResponse.of().saveUserRequest(saveUserRequest).build();
    }

    @Override
    public UpdateUserResponse updateUser(UpdateUserRequest updateUserRequest) {
        Optional<User> user = userRepository.getUserById(updateUserRequest.getUserId());
        if (user.get().getEnabled() == null) {
            user.get().setEnabled(1);
            userRepository.addUser(user.get());
        } else {
            userRepository.addUser(user.get());
        }
        return UpdateUserResponse.of().updateUserRequest(updateUserRequest).build();
    }

    @Override
    public DeleteUserResponse deleteUser(DeleteUserRequest deleteUserRequest) {
        Optional<User> user = userRepository.getUserById(deleteUserRequest.getUserId());
        if (user.isPresent()){
            userRepository.deleteUserById(user.get());
        }
        return DeleteUserResponse.of().deleteUserRequest(deleteUserRequest).build();
    }
    public List<UserDTO> getUsers() {
        List<User> users = userRepository.getUsers();
        return users.stream().map(u -> UserAssembler.toDTO(u)).collect(Collectors.toList());
    }

}
