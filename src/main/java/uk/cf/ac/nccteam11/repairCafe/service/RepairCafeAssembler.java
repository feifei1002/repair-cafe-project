package uk.cf.ac.nccteam11.repairCafe.service;

import uk.cf.ac.nccteam11.repairCafe.domain.RepairCafe;

public class RepairCafeAssembler {
    static RepairCafeDTO toDTO(RepairCafe rc) {
        return new RepairCafeDTO(rc.getCafeId(), rc.getName(), rc.getAddress(), rc.getCity(), rc.getPostcode());
    }
}
