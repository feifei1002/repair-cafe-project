package uk.cf.ac.nccteam11.repairCafe.service;

import org.springframework.stereotype.Service;
import uk.cf.ac.nccteam11.repairCafe.domain.RepairProduct;
import uk.cf.ac.nccteam11.repairCafe.repository.RepairProductRepository;
import uk.cf.ac.nccteam11.repairCafe.service.message.RepairProductListResponse;
import uk.cf.ac.nccteam11.repairCafe.service.message.RepairProductListRequest;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class RepairProductServiceImpl implements RepairProductService {

    private final RepairProductRepository repairProductRepository;
    public RepairProductServiceImpl(RepairProductRepository repairProductRepo) {repairProductRepository = repairProductRepo;}
    @Override
    public RepairProductListResponse getRepairProduct(RepairProductListRequest repairProductListRequest) {
        List<RepairProductDTO> repairProducts = getRepairProducts();
        return RepairProductListResponse.of()
                .request(repairProductListRequest)
                .repairProducts(repairProducts)
                .build();
    }

    public List<RepairProductDTO> getRepairProducts() {
        List<RepairProduct> repairProducts = repairProductRepository.getRepairProducts();
        return repairProducts.stream().map(rp -> RepairProductAssembler.toDTO(rp)).collect(Collectors.toList());
    }
}
