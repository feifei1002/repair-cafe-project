package uk.cf.ac.nccteam11.repairCafe.repository;

import org.springframework.data.repository.CrudRepository;
import uk.cf.ac.nccteam11.repairCafe.domain.RepairCafe;

import java.util.List;
import java.util.Optional;

public interface RepairCafeRepositoryJdbc extends CrudRepository<RepairCafe, Integer> {
    List<RepairCafe> findByPostcodeContaining(String postcode);
    Optional<RepairCafe> findById(Integer id);
}
