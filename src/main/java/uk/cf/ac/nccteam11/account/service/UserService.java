package uk.cf.ac.nccteam11.account.service;

import uk.cf.ac.nccteam11.account.service.message.SaveUserRequest;
import uk.cf.ac.nccteam11.account.service.message.SaveUserResponse;

public interface UserService {
    SaveUserResponse addNewUser(SaveUserRequest saveUserRequest);
}
