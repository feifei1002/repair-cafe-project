package uk.cf.ac.nccteam11.account.service;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class UserDTO {
    private Integer user_id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNo;
    private String password;
    private String address;
    private String city;
    private String postcode;
}
