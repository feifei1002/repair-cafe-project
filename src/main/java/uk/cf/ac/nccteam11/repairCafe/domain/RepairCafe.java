package uk.cf.ac.nccteam11.repairCafe.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@Table
public class RepairCafe {
    @Id
    @Column("cafe_id")
    private Integer cafeId;
    @Column("name")
    private String name;
    @Column("address")
    private String address;
    @Column("city")
    private String city;
    @Column("postcode")
    private String postcode;
    public static RepairCafe of(Integer cafe_id, String name, String address, String city, String postcode) {
        return new RepairCafe(cafe_id, name, address, city, postcode);
    }
}
