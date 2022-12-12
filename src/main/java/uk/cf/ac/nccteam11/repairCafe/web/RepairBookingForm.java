package uk.cf.ac.nccteam11.repairCafe.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepairBookingForm {
    private Integer bookingId;
    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    @Pattern(regexp=".+@.+\\.[a-z]+", message = "Invalid characters")
    private String email;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Future
    private Date repairDate;

    @NotEmpty
    private String category;

    @NotEmpty
    private String location;
}
