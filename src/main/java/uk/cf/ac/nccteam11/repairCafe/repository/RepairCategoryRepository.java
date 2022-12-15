package uk.cf.ac.nccteam11.repairCafe.repository;

import uk.cf.ac.nccteam11.repairCafe.domain.RepairCategory;
import uk.cf.ac.nccteam11.repairCafe.domain.RepairProduct;

import java.util.List;
import java.util.Optional;

public interface RepairCategoryRepository {
    List<RepairCategory> getRepairCategories();

}
