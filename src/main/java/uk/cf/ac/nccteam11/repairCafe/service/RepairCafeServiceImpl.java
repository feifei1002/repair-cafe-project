package uk.cf.ac.nccteam11.repairCafe.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import uk.cf.ac.nccteam11.repairCafe.domain.RepairCafe;
import uk.cf.ac.nccteam11.repairCafe.repository.RepairCafeRepository;

import java.util.List;

@Service
public class RepairCafeServiceImpl implements RepairCafeService {

    private final RepairCafeRepository repairCafeRepository;

    public RepairCafeServiceImpl(RepairCafeRepository repairCafeRepo) {
        repairCafeRepository = repairCafeRepo;
    }

    @Override
    public List<RepairCafeDTO> getRepairCafes() {
        List<RepairCafe> repairCafes = repairCafeRepository.getRepairCafes();
        return RepairCafeAssembler.toDTO(repairCafes);
    }
}
