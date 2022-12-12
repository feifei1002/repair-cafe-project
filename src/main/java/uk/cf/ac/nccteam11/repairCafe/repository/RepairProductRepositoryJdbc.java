package uk.cf.ac.nccteam11.repairCafe.repository;

import org.springframework.data.repository.CrudRepository;
import uk.cf.ac.nccteam11.repairCafe.domain.RepairProduct;

import java.util.List;
import java.util.Optional;

public interface RepairProductRepositoryJdbc extends CrudRepository<RepairProduct, Integer> {
    List<RepairProduct>findByProduct_nameContaining(String name);
    Optional<RepairProduct> findById(Integer id);
}
