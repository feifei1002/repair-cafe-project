package uk.cf.ac.nccteam11.repairCafe.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
