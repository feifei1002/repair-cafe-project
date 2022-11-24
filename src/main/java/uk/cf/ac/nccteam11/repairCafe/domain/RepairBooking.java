package uk.cf.ac.nccteam11.repairCafe.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class RepairBooking {
    private String booking_id;
    private String firstName;
    private String lastName;
    private String email;
    private Date repairDate;
    private String location;
}
