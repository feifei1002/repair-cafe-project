package uk.cf.ac.nccteam11.repairCafe.service;

import org.springframework.stereotype.Service;
import uk.cf.ac.nccteam11.repairCafe.domain.RepairCategory;
import uk.cf.ac.nccteam11.repairCafe.repository.RepairCategoryRepository;
import uk.cf.ac.nccteam11.repairCafe.service.message.RepairCategoryListRequest;
import uk.cf.ac.nccteam11.repairCafe.service.message.RepairCategoryListResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RepairCategoryServiceImpl implements RepairCategoryService{
    private final RepairCategoryRepository repairCategoryRepository;

    public RepairCategoryServiceImpl(RepairCategoryRepository repairCategoryRepo) {
        repairCategoryRepository = repairCategoryRepo;
    }

    @Override
    public RepairCategoryListResponse getRepairCategories(RepairCategoryListRequest repairCategoryListRequest) {
        List<RepairCategoryDTO> repairCategories = getRepairCategories();
        return RepairCategoryListResponse.of()
                .request(repairCategoryListRequest)
                .repairCategories(repairCategories)
                .build();
    }

    public List<RepairCategoryDTO> getRepairCategories() {
        List<RepairCategory> repairCategories = repairCategoryRepository.getRepairCategories();
        return repairCategories.stream().map(rc -> RepairCategoryAssembler.toDTO(rc)).collect(Collectors.toList());
    }
}
