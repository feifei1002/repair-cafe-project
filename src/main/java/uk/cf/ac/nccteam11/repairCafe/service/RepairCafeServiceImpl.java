package uk.cf.ac.nccteam11.repairCafe.service;

import org.springframework.stereotype.Service;
import uk.cf.ac.nccteam11.repairCafe.domain.RepairCafe;
import uk.cf.ac.nccteam11.repairCafe.repository.RepairCafeRepository;
import uk.cf.ac.nccteam11.repairCafe.service.message.RepairCafeListRequest;
import uk.cf.ac.nccteam11.repairCafe.service.message.RepairCafeListResponse;
import uk.cf.ac.nccteam11.repairCafe.service.message.SaveRepairCafeRequest;
import uk.cf.ac.nccteam11.repairCafe.service.message.SaveRepairCafeResponse;

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
        List<RepairCafeDTO> repairCafes;
        if(repairCafeListRequest.hasSearchTerm()){
            repairCafes = getRepairCafesBySearch(repairCafeListRequest.getSearchTerm());

        }else{
            repairCafes = getRepairCafes();
        }
        return RepairCafeListResponse.of()
                .request(repairCafeListRequest)
                .repairCafes(repairCafes)
                .build();
    }

    @Override
    public SaveRepairCafeResponse addNewRepairCafe(SaveRepairCafeRequest saveRepairCafeRequest){
        RepairCafeDTO repairCafeDTO = saveRepairCafeRequest.getRepairCafeDTO();
        RepairCafe newRepairCafe = new RepairCafe(
                repairCafeDTO.getCafe_id(),
                repairCafeDTO.getName(),
                repairCafeDTO.getAddress(),
                repairCafeDTO.getCity(),
                repairCafeDTO.getPostcode());
        repairCafeRepository.addRepairCafe(newRepairCafe);
        return SaveRepairCafeResponse.of().saveRepairCafeRequest(saveRepairCafeRequest).build();
    }

    public List<RepairCafeDTO> getRepairCafes() {
        List<RepairCafe> repairCafes = repairCafeRepository.getRepairCafes();
        return repairCafes.stream().map(rc -> RepairCafeAssembler.toDTO(rc)).collect(Collectors.toList());
    }

    private List<RepairCafeDTO> getRepairCafesBySearch(String search) {
        List<RepairCafe> repairCafes = repairCafeRepository.getRepairCafesBySearch(search);

        return repairCafes.stream().map(rc -> RepairCafeAssembler.toDTO(rc)).collect(Collectors.toList());
    }
}
