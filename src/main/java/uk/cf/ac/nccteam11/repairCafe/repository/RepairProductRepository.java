package uk.cf.ac.nccteam11.repairCafe.repository;

import uk.cf.ac.nccteam11.repairCafe.domain.RepairProduct;

import java.util.List;
import java.util.Optional;

public interface RepairProductRepository {
    List<RepairProduct> getRepairProducts();
    Optional<RepairProduct> getRepairProductsByByLocation(String location);
    List<RepairProduct> getRepairProductsBySearch(String search);

    Optional<RepairProduct> getRepairProductById(Integer id);
    void save(RepairProduct repairProduct);
    void deleteRepairProductById(RepairProduct repairProduct);

    List<RepairProduct> getRepairProductsByCategoryId(Integer repair_Category_category_id);
}
