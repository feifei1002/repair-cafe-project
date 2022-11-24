package uk.cf.ac.nccteam11.repairCafe.service;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class RepairCafeDTO {
    private String name;
    private String cafe_id;
    private String address;
}
