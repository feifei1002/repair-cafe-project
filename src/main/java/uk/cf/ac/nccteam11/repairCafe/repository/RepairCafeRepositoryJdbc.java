package uk.cf.ac.nccteam11.repairCafe.repository;

import org.springframework.data.repository.CrudRepository;
import uk.cf.ac.nccteam11.repairCafe.domain.RepairCafe;

public interface RepairCafeRepositoryJdbc extends CrudRepository<RepairCafe, Integer> {
}
