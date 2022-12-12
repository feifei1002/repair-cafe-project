package uk.cf.ac.nccteam11.repairCafe.repository;

import uk.cf.ac.nccteam11.repairCafe.domain.RepairCafe;

import java.util.List;
import java.util.Optional;

public interface RepairCafeRepository {
    List<RepairCafe> getRepairCafes();
    List<RepairCafe> getRepairCafesBySearch(String search);
    Optional<RepairCafe> getRepairCafeById(Integer id);
    void save(RepairCafe repairCafe);
    void deleteRepairCafeById(RepairCafe repairCafe);
}
