package uk.cf.ac.nccteam11.repairCafe.repository;

import org.springframework.data.repository.CrudRepository;
import uk.cf.ac.nccteam11.repairCafe.domain.RepairCategory;

public interface RepairCategoryRepositoryJdbc extends CrudRepository<RepairCategory, Integer> {
}
