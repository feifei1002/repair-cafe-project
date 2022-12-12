package uk.cf.ac.nccteam11.repairCafe.repository;

import uk.cf.ac.nccteam11.repairCafe.domain.RepairCategory;

import java.util.List;

public interface RepairCategoryRepository {
    List<RepairCategory> getRepairCategories();
}
