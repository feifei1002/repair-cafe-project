package uk.cf.ac.nccteam11.repairCafe.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepairProductRentForm {
    private Integer productId;
    private String productName;
    private String condition;
    private String brand;
    private String status;
    private String isApproved;
}
