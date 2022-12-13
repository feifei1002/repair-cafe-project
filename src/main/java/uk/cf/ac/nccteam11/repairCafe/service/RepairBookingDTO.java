package uk.cf.ac.nccteam11.repairCafe.service;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.Date;

@Value
@AllArgsConstructor
public class RepairBookingDTO {
    private Integer bookingId;
    private String firstName;
    private String lastName;
    private String email;
    private Date repairDate;
    private String category;
    private String location;
}
