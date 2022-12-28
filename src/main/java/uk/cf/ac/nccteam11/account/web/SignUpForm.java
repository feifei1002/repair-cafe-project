package uk.cf.ac.nccteam11.account.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpForm {
    private Integer userId;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    @Pattern(regexp=".+@.+\\.[a-z]+", message = "Invalid characters")
    private String email;

    @NotEmpty
    private String phoneNo;

    @NotEmpty
    @Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]{8,})$",
    message = "Password must have minimum of 8 characters, including 1 upper case letter, 1 lowercase letter, 1 number and 1 special character")
    private String password;

    @NotEmpty
    private String address;

    @NotEmpty
    private String city;

    @NotEmpty
    private String postcode;
    private String role;
    private Integer enabled;

}
