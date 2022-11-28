package uk.cf.ac.nccteam11.repairCafe.service;

import uk.cf.ac.nccteam11.repairCafe.domain.RepairCategory;

public class RepairCategoryAssembler {
    static RepairCategoryDTO toDTO(RepairCategory rc) {
        return new RepairCategoryDTO(rc.getCategory_id(), rc.getName());
    }
}
