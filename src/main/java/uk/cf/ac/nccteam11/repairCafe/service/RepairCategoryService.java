package uk.cf.ac.nccteam11.repairCafe.service;

import uk.cf.ac.nccteam11.repairCafe.service.message.RepairCategoryListRequest;
import uk.cf.ac.nccteam11.repairCafe.service.message.RepairCategoryListResponse;

public interface RepairCategoryService {
    RepairCategoryListResponse getRepairCategories(RepairCategoryListRequest repairCategoryListRequest);
}
