package uk.cf.ac.nccteam11.repairCafe.service.message;

import lombok.Builder;
import lombok.Value;
import uk.cf.ac.nccteam11.repairCafe.service.RepairCategoryDTO;

@Value
@Builder(builderMethodName = "of")
public class SaveRepairCategoryRequest {
    private final RepairCategoryDTO repairCategoryDTO;
}