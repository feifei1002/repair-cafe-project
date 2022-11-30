package uk.cf.ac.nccteam11.product.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@Table
public class Product {
    @Id
    @Column("PRODUCT_ID")
    private Integer product_id;

    @Column("NAME")
    private String name;

    @Column("DESCRIPTION")
    private String description;

    @Column("LOCATION")
    private String location;

    @Column("STATUS")
    private String status;
}
