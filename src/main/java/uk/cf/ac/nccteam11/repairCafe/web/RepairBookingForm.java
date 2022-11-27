package uk.cf.ac.nccteam11.repairCafe.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepairBookingForm {
    private Integer booking_id;
    private String firstName;
    private String lastName;
    private String email;
    private Date repairDate;
    private String category;
    private String location;
}
