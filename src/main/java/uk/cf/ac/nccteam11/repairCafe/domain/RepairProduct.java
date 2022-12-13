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
}
