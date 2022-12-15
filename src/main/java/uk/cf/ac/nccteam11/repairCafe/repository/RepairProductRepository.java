package uk.cf.ac.nccteam11.repairCafe.repository;


import uk.cf.ac.nccteam11.repairCafe.domain.RepairProduct;

import java.util.List;
import java.util.Optional;


public interface RepairProductRepository {
    List<RepairProduct> getRepairProducts();

    List<RepairProduct> getRepairProductsByCategoryId(Integer repair_Category_category_id);

    Optional<RepairProduct> getRepairProductById(Integer product_id);
}
