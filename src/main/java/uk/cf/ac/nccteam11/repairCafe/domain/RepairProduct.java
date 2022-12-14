package uk.cf.ac.nccteam11.repairCafe.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;
import uk.cf.ac.nccteam11.repairCafe.service.RepairBorrowDTO;

import java.util.Set;

@Data
@AllArgsConstructor
@Table

public class RepairProduct {
    @Id
    @Column("PRODUCT_ID")
    private Integer productId;
    @Column("PRODUCT_NAME")
    private String productName;
    @Column("CONDITION")
    private String condition;
    @Column("BRAND")
    private String brand;
    @Column("STATUS")
    private String status;
    @Column("IS_APPROVED")
    private String isApproved;

    @MappedCollection(idColumn = "PRODUCT_ID")
//    private RepairBorrow repairBorrow;
    private Set<RepairBorrow> repairBorrows;

//    public static RepairProduct of(Integer productId, String productName, String condition, String brand, String status, String isApproved) {
//        return new RepairProduct(productId, productName, condition, brand, status, isApproved, null);
//    }
    public void addBorrow(RepairBorrowDTO repairBorrowDTO){
        repairBorrows.add(RepairBorrow.of(repairBorrowDTO.getBorrowId(),
                repairBorrowDTO.getFirstName(), repairBorrowDTO.getLastName(),
                repairBorrowDTO.getEmail()));
    }

    public void updateBorrow(RepairBorrowDTO repairBorrowDTO) {
        RepairBorrow borrowToChange = getRepairBorrowByDTO(repairBorrowDTO);
    }

    private RepairBorrow getRepairBorrowByDTO(RepairBorrowDTO repairBorrowDTO) {
        RepairBorrow borrowToChange = repairBorrows
                .stream()
                .filter(rb -> rb.getBorrowId().equals(repairBorrowDTO.getBorrowId()))
                .findFirst()
                .get();
        return borrowToChange;
    }
}
