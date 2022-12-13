package uk.cf.ac.nccteam11.repairCafe.service;

import uk.cf.ac.nccteam11.repairCafe.service.message.*;

public interface RepairProductService {
    RepairProductListResponse getRepairProducts(RepairProductListRequest repairProductListRequest);
    SingleRepairProductResponse getRepairProductByRequest(SingleRepairProductRequest singleRepairProductRequest);
    DeleteRepairProductResponse deleteRepairProduct(DeleteRepairProductRequest deleteRepairProductRequest);
    UpdateRepairProductResponse updateRepairProduct(UpdateRepairProductRequest updateRepairProductRequest);
}
