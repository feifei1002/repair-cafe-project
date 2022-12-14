package uk.cf.ac.nccteam11.repairCafe.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepairProductBorrowForm {
    private Integer borrowId;
    private String firstName;
    private String lastName;
    private String email;
    private String productName;
    private Integer productId;
}
