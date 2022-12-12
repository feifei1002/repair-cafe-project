package uk.cf.ac.nccteam11.repairCafe.repository;

import org.springframework.stereotype.Repository;
import uk.cf.ac.nccteam11.repairCafe.domain.RepairCategory;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepairCategoryRepositoryImpl implements RepairCategoryRepository{
    private final RepairCategoryRepositoryJdbc repairCategoryRepoJdbc;

    public RepairCategoryRepositoryImpl(RepairCategoryRepositoryJdbc rcRepoJdbc){
        this.repairCategoryRepoJdbc = rcRepoJdbc;
    }

    public List<RepairCategory> getRepairCategories() {
        List<RepairCategory> repairCategories = new ArrayList<>();
        repairCategoryRepoJdbc.findAll().forEach(repairCategories::add);
        return repairCategories;
    }
}
