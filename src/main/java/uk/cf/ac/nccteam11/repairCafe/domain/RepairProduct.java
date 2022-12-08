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
    private String product_name;
    private String condition;
    private String brand;
    private String status;
}
