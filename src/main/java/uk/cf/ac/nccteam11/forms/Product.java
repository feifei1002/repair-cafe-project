package uk.cf.ac.nccteam11.forms;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

    private Integer ID;
    private String Name;
    private String Description;
    private String Category;
    private String Location;
    private Boolean Status;
    private Boolean Availability;

    public Product(Integer ID, String Name, String Description, String Category, String Location) {
        this(ID, Name, Description, Category, Location, Boolean.FALSE, Boolean.FALSE);
    }

    public Product() {

    }
}
