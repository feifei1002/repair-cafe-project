package uk.cf.ac.nccteam11.repairCafe.repository;

import org.springframework.data.repository.CrudRepository;
import uk.cf.ac.nccteam11.repairCafe.domain.RepairCafe;

import java.util.List;

public interface RepairCafeRepositoryJdbc extends CrudRepository<RepairCafe, Integer> {
    List<RepairCafe> findByPostcodeContaining(String postcode);
}
