package uk.cf.ac.nccteam11.repairCafe.service;

import uk.cf.ac.nccteam11.repairCafe.service.message.*;

public interface RepairProductService {
    RepairProductListResponse getRepairProducts(RepairProductListRequest repairProductListRequest);
    SingleRepairProductResponse getRepairProductByRequest(SingleRepairProductRequest singleRepairProductRequest);
    SaveRepairProductResponse addNewRepairProduct(SaveRepairProductRequest saveRepairProductRequest);
    DeleteRepairProductResponse deleteRepairProduct(DeleteRepairProductRequest deleteRepairProductRequest);
    UpdateRepairProductResponse updateRepairProduct(UpdateRepairProductRequest updateRepairProductRequest);
    UpdateRepairProductResponse updateRepairProductStatus(UpdateRepairProductRequest updateRepairProductRequest);
    UpdateRepairBorrowResponse updateRepairBorrow(UpdateRepairBorrowRequest updateRepairBorrowRequest);
    SingleRepairBorrowResponse getRepairBorrowByRequest(SingleRepairBorrowRequest singleRepairBorrowRequest);
}
