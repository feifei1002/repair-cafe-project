package uk.cf.ac.nccteam11.repairCafe.service;

import org.springframework.stereotype.Service;
import uk.cf.ac.nccteam11.repairCafe.domain.RepairCafe;
import uk.cf.ac.nccteam11.repairCafe.repository.RepairCafeRepository;
import uk.cf.ac.nccteam11.repairCafe.service.message.*;

import java.util.List;
import java.util.Optional;
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
    public SingleRepairCafeResponse getRepairCafeByRequest(SingleRepairCafeRequest singleRepairCafeRequest) {
        Optional<RepairCafe> repairCafe = repairCafeRepository.getRepairCafeById(singleRepairCafeRequest.getCafe_id());
        RepairCafeDTO repairCafeDTO;
        if(repairCafe.isPresent()){
            repairCafeDTO = RepairCafeAssembler.toDTO(repairCafe.get());
        }else{
            repairCafeDTO = null;
        }
        return SingleRepairCafeResponse.of()
                .singleRepairCafeRequest(singleRepairCafeRequest)
                .repairCafeDTO(repairCafeDTO).build();
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
        repairCafeRepository.save(newRepairCafe);
        return SaveRepairCafeResponse.of().saveRepairCafeRequest(saveRepairCafeRequest).build();
    }

    @Override
    public UpdateRepairCafeResponse updateRepairCafe(UpdateRepairCafeRequest updateRepairCafeRequest) {
        Optional<RepairCafe> repairCafe = repairCafeRepository.getRepairCafeById(updateRepairCafeRequest.getCafe_id());
        repairCafeRepository.save(repairCafe.get());
        return UpdateRepairCafeResponse.of().updateRepairCafeRequest(updateRepairCafeRequest).build();
    }

    @Override
    public DeleteRepairCafeResponse deleteRepairCafe(DeleteRepairCafeRequest deleteRepairCafeRequest) {
        Optional<RepairCafe> repairCafe = repairCafeRepository.getRepairCafeById(deleteRepairCafeRequest.getCafeId());
        if(repairCafe.isPresent()){
            repairCafeRepository.deleteRepairCafeById(repairCafe.get());
        }
        return DeleteRepairCafeResponse.of().deleteRepairCafeRequest(deleteRepairCafeRequest).build();
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
