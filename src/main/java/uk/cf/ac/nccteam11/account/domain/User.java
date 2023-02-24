package uk.cf.ac.nccteam11.account.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@Table
public class User {
    @Id
    @Column("user_id")
    private Integer userId;

    @Column("firstName")
    private String firstName;

    @Column("lastName")
    private String lastName;

    @Column("email")
    private String email;

    @Column("phoneNo")
    private String phoneNo;

    @Column("password")
    private String password;

    @Column("address")
    private String address;

    @Column("city")
    private String city;

    @Column("postcode")
    private String postcode;

    @Column("role")
    private String role;

    @Column("enabled")
    private Integer enabled;
}
