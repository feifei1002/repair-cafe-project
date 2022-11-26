package uk.cf.ac.nccteam11.repairCafe.service;

import org.springframework.stereotype.Service;
import uk.cf.ac.nccteam11.repairCafe.domain.RepairCafe;
import uk.cf.ac.nccteam11.repairCafe.repository.RepairCafeRepository;
import uk.cf.ac.nccteam11.repairCafe.service.message.RepairCafeListRequest;
import uk.cf.ac.nccteam11.repairCafe.service.message.RepairCafeListResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RepairCafeServiceImpl implements RepairCafeService {

    private final RepairCafeRepository repairCafeRepository;

    public RepairCafeServiceImpl(RepairCafeRepository repairCafeRepo) {
        repairCafeRepository = repairCafeRepo;
    }
    @Override
    public RepairCafeListResponse getRepairCafes(RepairCafeListRequest repairCafeListRequest) {
        List<RepairCafeDTO> repairCafes = getRepairCafes();
        return RepairCafeListResponse.of()
                .request(repairCafeListRequest)
                .repairCafes(repairCafes)
                .build();
    }

    public List<RepairCafeDTO> getRepairCafes() {
        List<RepairCafe> repairCafes = repairCafeRepository.getRepairCafes();
        return repairCafes.stream().map(rc -> RepairCafeAssembler.toDTO(rc)).collect(Collectors.toList());
    }
}
