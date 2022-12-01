package uk.cf.ac.nccteam11.account.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpForm {
    private Integer user_id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String firstLineAddress;
    private String town;
    private String city;
    private String postcode;

}
