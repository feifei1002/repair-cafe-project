package uk.cf.ac.nccteam11.repairCafe.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@Table
public class RepairBorrow {
    @Id
    @Column("BORROW_ID")
    private Integer borrowId;
    @Column("FIRSTNAME")
    private String firstName;
    @Column("LASTNAME")
    private String lastName;
    @Column("EMAIL")
    private String email;

    public static RepairBorrow of(Integer borrowId, String firstName, String lastName, String email) {
        return new RepairBorrow(borrowId, firstName, lastName, email);
    }
}
