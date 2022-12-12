package uk.cf.ac.nccteam11.repairCafe.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@Table
public class RepairCategory {
    @Id
    @Column("CATEGORY_ID")
    private Integer categoryId;
    @Column("NAME")
    private String name;
}
