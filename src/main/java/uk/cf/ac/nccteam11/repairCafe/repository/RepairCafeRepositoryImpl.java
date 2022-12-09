package uk.cf.ac.nccteam11.repairCafe.repository;

import org.springframework.stereotype.Repository;
import uk.cf.ac.nccteam11.repairCafe.domain.RepairCafe;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    @Override
    public List<RepairCafe> getRepairCafesBySearch(String search) {
        return repairCafeRepoJdbc.findByPostcodeContaining(search);
    }

    @Override
    public Optional<RepairCafe> getRepairCafeById(Integer id) {
        return repairCafeRepoJdbc.findById(id);
    }

    @Override
    public void addRepairCafe(RepairCafe repairCafe){
        repairCafeRepoJdbc.save(repairCafe);
    }

    @Override
    public void deleteRepairCafeById(RepairCafe repairCafe) {
        repairCafeRepoJdbc.deleteById(repairCafe.getCafe_id());
    }
}
