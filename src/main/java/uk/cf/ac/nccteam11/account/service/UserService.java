package uk.cf.ac.nccteam11.account.service;

import uk.cf.ac.nccteam11.account.service.message.*;

public interface UserService {
    UserListResponse getUsers(UserListRequest userListRequest);
    SaveUserResponse addNewUser(SaveUserRequest saveUserRequest);
    UpdateUserResponse updateUser(UpdateUserRequest updateUserRequest);
    DeleteUserResponse deleteUser(DeleteUserRequest deleteUserRequest);
}
