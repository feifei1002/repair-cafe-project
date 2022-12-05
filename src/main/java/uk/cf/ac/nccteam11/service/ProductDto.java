package uk.cf.ac.nccteam11.service;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class ProductDto {

    private Integer productID;
    private String name;
    private String description;
    private String category;
    private String location;
    private Boolean status;
    private Boolean availability;

}
