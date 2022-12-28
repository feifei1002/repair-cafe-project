package uk.cf.ac.nccteam11.repairCafe.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class RepairCafeAddForm {
    private Integer cafeId;

    @NotEmpty
    private String name;

    @NotEmpty
    private String address;

    @NotEmpty
    private String city;

    @NotEmpty
    private String postcode;
}
