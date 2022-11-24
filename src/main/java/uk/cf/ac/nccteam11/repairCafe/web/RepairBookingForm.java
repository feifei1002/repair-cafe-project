package uk.cf.ac.nccteam11.repairCafe.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepairBookingForm {
    private String firstName;
    private String lastName;
    private String email;
    private Date repairDate;
    private String location;
}
