package uk.cf.ac.nccteam11.repairCafe.service;

import uk.cf.ac.nccteam11.repairCafe.service.message.RepairCafeListRequest;
import uk.cf.ac.nccteam11.repairCafe.service.message.RepairCafeListResponse;
import uk.cf.ac.nccteam11.repairCafe.service.message.SaveRepairCafeRequest;
import uk.cf.ac.nccteam11.repairCafe.service.message.SaveRepairCafeResponse;

public interface RepairCafeService {

    RepairCafeListResponse getRepairCafes(RepairCafeListRequest repairCafeListRequest);
    SaveRepairCafeResponse addNewRepairCafe(SaveRepairCafeRequest saveRepairCafeRequest);
}
