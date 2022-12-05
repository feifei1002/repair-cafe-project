package uk.cf.ac.nccteam11.account.service;

import org.springframework.stereotype.Service;
import uk.cf.ac.nccteam11.account.domain.User;
import uk.cf.ac.nccteam11.account.repository.UserRepository;
import uk.cf.ac.nccteam11.account.service.message.SaveUserRequest;
import uk.cf.ac.nccteam11.account.service.message.SaveUserResponse;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl (UserRepository userRepo){
        this.userRepository = userRepo;
    }

    @Override
    public SaveUserResponse addNewUser(SaveUserRequest saveUserRequest) {
        UserDTO userDTO = saveUserRequest.getUserDTO();
        User newUser = new User(
                userDTO.getUser_id(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail(),
                userDTO.getPassword(),
                userDTO.getFirstLineAddress(),
                userDTO.getTown(),
                userDTO.getCity(),
                userDTO.getPostcode());
        userRepository.addUser(newUser);
        return SaveUserResponse.of().saveUserRequest(saveUserRequest).build();
    }

}
