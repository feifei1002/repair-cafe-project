package uk.cf.ac.nccteam11.repairCafe.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepairProductRentForm {
    private Integer productId;
    @NotEmpty
    private String productName;
    @NotEmpty
    private String condition;
    @NotEmpty
    private String brand;
    @NotEmpty
    private String status;
    private String isApproved;
}
