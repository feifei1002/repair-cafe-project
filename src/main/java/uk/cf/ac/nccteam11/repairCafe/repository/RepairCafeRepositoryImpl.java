package uk.cf.ac.nccteam11.repairCafe.repository;

import org.springframework.stereotype.Repository;
import uk.cf.ac.nccteam11.repairCafe.domain.RepairCafe;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RepairCafeRepositoryImpl implements RepairCafeRepository {
    private final RepairCafeRepositoryJdbc repairCafeRepoJdbc;

    public RepairCafeRepositoryImpl(RepairCafeRepositoryJdbc rcRepoJdbc) {
        this.repairCafeRepoJdbc = rcRepoJdbc;
    }

    public List<RepairCafe> getRepairCafes() {
        List<RepairCafe> repairCafes = new ArrayList<>();
        repairCafeRepoJdbc.findAll().forEach(repairCafes::add);
        return repairCafes;
    }


}
