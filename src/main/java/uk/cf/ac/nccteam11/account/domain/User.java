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
    @Column("USER_ID")
    private Integer user_id;

    @Column("FIRSTNAME")
    private String firstName;

    @Column("LASTNAME")
    private String lastName;

    @Column("EMAIL")
    private String email;

    @Column("PASSWORD")
    private String password;

    @Column("FIRSTLINEADDRESS")
    private String firstLineAddress;

    @Column("TOWN")
    private String town;

    @Column("CITY")
    private String city;

    @Column("POSTCODE")
    private String postcode;
}
