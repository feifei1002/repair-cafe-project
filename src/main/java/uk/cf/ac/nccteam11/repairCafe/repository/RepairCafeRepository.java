package uk.cf.ac.nccteam11.repairCafe.repository;

import uk.cf.ac.nccteam11.repairCafe.domain.RepairCafe;

import java.util.List;

public interface RepairCafeRepository {
    List<RepairCafe> getRepairCafes();
    List<RepairCafe> getRepairCafesBySearch(String search);
}
