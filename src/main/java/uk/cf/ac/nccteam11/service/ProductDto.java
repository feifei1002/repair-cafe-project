package uk.cf.ac.nccteam11.service;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class ProductDto {

    private Integer ID;
    private String Name;
    private String Description;
    private String Category;
    private String Location;
    private Boolean Status;
    private Boolean Availability;

}
