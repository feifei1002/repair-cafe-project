package uk.cf.ac.nccteam11.repairCafe.service;

import uk.cf.ac.nccteam11.repairCafe.service.message.RepairCafeListRequest;
import uk.cf.ac.nccteam11.repairCafe.service.message.RepairCafeListResponse;

public interface RepairCafeService {

    RepairCafeListResponse getRepairCafes(RepairCafeListRequest repairCafeListRequest);
}
