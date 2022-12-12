package uk.cf.ac.nccteam11.repairCafe.service;

import uk.cf.ac.nccteam11.repairCafe.service.message.RepairProductListRequest;
import uk.cf.ac.nccteam11.repairCafe.service.message.RepairProductListResponse;
import uk.cf.ac.nccteam11.repairCafe.service.message.SingleRepairProductRequest;
import uk.cf.ac.nccteam11.repairCafe.service.message.SingleRepairProductResponse;

public interface RepairProductService {
    RepairProductListResponse getRepairProducts(RepairProductListRequest repairProductListRequest);
    SingleRepairProductResponse getRepairProductByRequest(SingleRepairProductRequest singleRepairProductRequest);
}
