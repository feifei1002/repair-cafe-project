package uk.cf.ac.nccteam11.repairCafe.service;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class RepairBorrowDTO {
    private Integer borrowId;
    private String firstName;
    private String lastName;
    private String email;
    private String productName;
    private Integer productId;

    public RepairBorrowDTO of(Integer borrowId, String firstName, String lastName, String email) {
        return new RepairBorrowDTO(borrowId, firstName, lastName, email, productName, productId);
    }
}
