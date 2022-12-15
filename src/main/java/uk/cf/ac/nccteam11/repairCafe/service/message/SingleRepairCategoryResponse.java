package uk.cf.ac.nccteam11.repairCafe.service.message;

import lombok.Builder;
import lombok.Value;

import uk.cf.ac.nccteam11.repairCafe.service.RepairCategoryDTO;

@Value
@Builder(builderMethodName = "of")
public class SingleRepairCategoryResponse {
    private final SingleRepairCategoryRequest singleRepairCategoryRequest;
    private final RepairCategoryDTO repairCategoryDTO;
}
