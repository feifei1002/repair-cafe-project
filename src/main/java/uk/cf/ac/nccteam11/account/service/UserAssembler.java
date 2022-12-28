package uk.cf.ac.nccteam11.account.service;

import uk.cf.ac.nccteam11.account.domain.User;

public class UserAssembler {
    static UserDTO toDTO(User u) {
        return new UserDTO(u.getUserId(), u.getFirstName(), u.getLastName(), u.getEmail(), u.getPhoneNo(), u.getPassword(), u.getAddress(), u.getCity(), u.getPostcode(), u.getRole(), u.getEnabled());
    }
}
