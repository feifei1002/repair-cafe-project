package uk.cf.ac.nccteam11.repairCafe.service.message;

import lombok.Builder;
import lombok.Value;

import uk.cf.ac.nccteam11.repairCafe.service.RepairCategoryDTO;
@Value
@Builder(builderMethodName = "of")
public class UpdateRepairCategoryRequest {
    private final Integer category_id;
    private final RepairCategoryDTO repairCategoryDTO;
}
