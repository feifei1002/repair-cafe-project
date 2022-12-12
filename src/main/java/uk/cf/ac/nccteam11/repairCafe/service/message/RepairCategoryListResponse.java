package uk.cf.ac.nccteam11.repairCafe.service.message;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import uk.cf.ac.nccteam11.repairCafe.service.RepairCategoryDTO;

import java.util.List;

@Value
@AllArgsConstructor
@Builder(builderMethodName="of")
public class RepairCategoryListResponse {
    private RepairCategoryListRequest request;
    private List<RepairCategoryDTO> repairCategories;
}
