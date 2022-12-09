package uk.cf.ac.nccteam11.repairCafe.service;

import uk.cf.ac.nccteam11.repairCafe.service.message.RepairProductListRequest;
import uk.cf.ac.nccteam11.repairCafe.service.message.RepairProductListResponse;

public interface RepairProductService {
    RepairProductListResponse getRepairProduct(RepairProductListRequest repairProductListRequest);
}
