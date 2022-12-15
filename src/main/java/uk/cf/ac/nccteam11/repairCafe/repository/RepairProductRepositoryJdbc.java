package uk.cf.ac.nccteam11.repairCafe.repository;

import org.springframework.data.repository.CrudRepository;
import uk.cf.ac.nccteam11.repairCafe.domain.RepairProduct;

import java.util.List;

public interface RepairProductRepositoryJdbc extends CrudRepository<RepairProduct, Integer> {

}

