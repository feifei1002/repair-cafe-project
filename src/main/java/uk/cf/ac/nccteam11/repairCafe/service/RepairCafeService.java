package uk.cf.ac.nccteam11.repairCafe.service;

import uk.cf.ac.nccteam11.repairCafe.service.message.*;

public interface RepairCafeService {

    RepairCafeListResponse getRepairCafes(RepairCafeListRequest repairCafeListRequest);
    SingleRepairCafeResponse getRepairCafeByRequest(SingleRepairCafeRequest singleRepairCafeRequest);
    SaveRepairCafeResponse addNewRepairCafe(SaveRepairCafeRequest saveRepairCafeRequest);
    UpdateRepairCafeResponse updateRepairCafe(UpdateRepairCafeRequest updateRepairCafeRequest);
    DeleteRepairCafeResponse deleteRepairCafe(DeleteRepairCafeRequest deleteRepairCafeRequest);
}
