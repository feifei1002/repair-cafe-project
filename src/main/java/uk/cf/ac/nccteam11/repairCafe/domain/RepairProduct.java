package uk.cf.ac.nccteam11.repairCafe.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@Table

public class RepairProduct {
    @Id
    @Column("product_id")
    private Integer productId;
    @Column("product_name")
    private String productName;
    @Column("condition")
    private String condition;
    @Column("brand")
    private String brand;
    @Column("status")
    private String status;
    @Column("is_Approved")
    private String isApproved;

//    @MappedCollection(idColumn = "PRODUCT_ID")
////    private RepairBorrow repairBorrow;
//    private Set<RepairBorrow> repairBorrows;
//
////    public static RepairProduct of(Integer productId, String productName, String condition, String brand, String status, String isApproved) {
////        return new RepairProduct(productId, productName, condition, brand, status, isApproved, null);
////    }
//    public void addBorrow(RepairBorrowDTO repairBorrowDTO){
//        repairBorrows.add(RepairBorrow.of(repairBorrowDTO.getBorrowId(),
//                repairBorrowDTO.getFirstName(), repairBorrowDTO.getLastName(),
//                repairBorrowDTO.getEmail()));
//    }
//
//    public void updateBorrow(RepairBorrowDTO repairBorrowDTO) {
//        RepairBorrow borrowToChange = getRepairBorrowByDTO(repairBorrowDTO);
//    }
//
//    private RepairBorrow getRepairBorrowByDTO(RepairBorrowDTO repairBorrowDTO) {
//        RepairBorrow borrowToChange = repairBorrows
//                .stream()
//                .filter(rb -> rb.getBorrowId().equals(repairBorrowDTO.getBorrowId()))
//                .findFirst()
//                .get();
//        return borrowToChange;
//    }
}
