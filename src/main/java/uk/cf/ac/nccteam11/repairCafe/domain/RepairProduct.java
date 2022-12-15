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
    private Integer product_id;
    @Column("PRODUCT_NAME")
    private String product_name;
    @Column("CONDITION")
    private String condition;
    @Column("BRAND")
    private String brand;
    @Column("STATUS")
    private String status;
    @Column("REPAIR_CATEGORY_CATEGORY_ID")
    private Integer repair_Category_category_id;
}
