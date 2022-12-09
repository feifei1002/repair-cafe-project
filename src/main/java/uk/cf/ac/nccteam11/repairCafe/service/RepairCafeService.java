package uk.cf.ac.nccteam11.repairCafe.service;

import uk.cf.ac.nccteam11.repairCafe.service.message.*;

public interface RepairCafeService {

    RepairCafeListResponse getRepairCafes(RepairCafeListRequest repairCafeListRequest);
    SaveRepairCafeResponse addNewRepairCafe(SaveRepairCafeRequest saveRepairCafeRequest);
    DeleteRepairCafeResponse deleteRepairCafe(DeleteRepairCafeRequest deleteRepairCafeRequest);
}
