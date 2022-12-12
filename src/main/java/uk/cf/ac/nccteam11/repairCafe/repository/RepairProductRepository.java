package uk.cf.ac.nccteam11.repairCafe.repository;

import uk.cf.ac.nccteam11.repairCafe.domain.RepairProduct;

import java.util.List;

public interface RepairProductRepository {
    List<RepairProduct> getRepairProducts();
}
