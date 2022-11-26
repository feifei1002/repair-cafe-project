package uk.cf.ac.nccteam11.repairCafe.service;

import uk.cf.ac.nccteam11.repairCafe.domain.RepairCafe;

public class RepairCafeAssembler {
    static RepairCafeDTO toDTO(RepairCafe rc) {
        return new RepairCafeDTO(rc.getCafe_id(), rc.getName(), rc.getAddress());
    }
}
