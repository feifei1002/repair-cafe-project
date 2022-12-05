package uk.cf.ac.nccteam11.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table
@AllArgsConstructor
public class Product {

    private Integer productID;
    private String name;
    private String description;
    private String category;
    private String location;
    private Boolean status;
    private Boolean availability;

    public Product(Integer productID, String name, String description, String category, String location) {
        this(productID, name, description, category, location, Boolean.FALSE, Boolean.FALSE);
    }

    public Product() {

    }
}
