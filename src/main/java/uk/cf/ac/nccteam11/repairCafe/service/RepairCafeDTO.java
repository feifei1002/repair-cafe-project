package uk.cf.ac.nccteam11.repairCafe.service;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class RepairCafeDTO {
    private Integer cafe_id;
    private String name;
    private String address;
    private String city;
    private String postcode;
}
