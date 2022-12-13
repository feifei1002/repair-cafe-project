package uk.cf.ac.nccteam11.repairCafe.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Data
@AllArgsConstructor
@Table
public class RepairBooking {
    @Id
    @Column("BOOKING_ID")
    private Integer bookingId;
    @Column("FIRSTNAME")
    private String firstName;
    @Column("LASTNAME")
    private String lastName;
    @Column("EMAIL")
    private String email;
    @Column("REPAIRDATE")
    private Date repairDate;
    @Column("CATEGORY")
    private String category;
    @Column("LOCATION")
    private String location;
}
