package uk.cf.ac.nccteam11.repairCafe.service;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class RepairCafeDTO {
    private String cafe_id;
    private String name;
    private String address;
}
