package uk.cf.ac.nccteam11.repairCafe.service;

import org.springframework.stereotype.Service;
import uk.cf.ac.nccteam11.repairCafe.domain.RepairProduct;
import uk.cf.ac.nccteam11.repairCafe.repository.RepairProductRepository;
import uk.cf.ac.nccteam11.repairCafe.service.message.*;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RepairProductServiceImpl implements RepairProductService {

    private final RepairProductRepository repairProductRepository;
    public RepairProductServiceImpl(RepairProductRepository repairProductRepo) {repairProductRepository = repairProductRepo;}
    @Override
    public RepairProductListResponse getRepairProducts(RepairProductListRequest repairProductListRequest) {
        List<RepairProductDTO> repairProducts = getRepairProducts();
        return RepairProductListResponse.of()
                .request(repairProductListRequest)
                .repairProducts(repairProducts)
                .build();
    }

    @Override
    public SingleRepairProductResponse getRepairProductByRequest(SingleRepairProductRequest singleRepairProductRequest) {
        Optional<RepairProduct> repairProduct = repairProductRepository.getRepairProductById(singleRepairProductRequest.getProductId());
        RepairProductDTO repairProductDTO;
        if(repairProduct.isPresent()){
            repairProductDTO = RepairProductAssembler.toDTO(repairProduct.get());
        }else{
            repairProductDTO = null;
        }
        return SingleRepairProductResponse.of()
                .singleRepairProductRequest(singleRepairProductRequest)
                .repairProductDTO(repairProductDTO)
                .build();
    }

    @Override
    public SaveRepairProductResponse addNewRepairProduct(SaveRepairProductRequest saveRepairProductRequest) {
        RepairProductDTO repairProductDTO = saveRepairProductRequest.getRepairProductDTO();
        RepairProduct repairProduct = new RepairProduct(
                repairProductDTO.getProductId(),
                repairProductDTO.getProductName(),
                repairProductDTO.getCondition(),
                repairProductDTO.getBrand(),
                repairProductDTO.getStatus(),
                repairProductDTO.getIsApproved());
        repairProductRepository.save(repairProduct);
        return SaveRepairProductResponse.of().saveRepairProductRequest(saveRepairProductRequest).build();
    }

    @Override
    public DeleteRepairProductResponse deleteRepairProduct(DeleteRepairProductRequest deleteRepairProductRequest) {
        Optional<RepairProduct> repairProduct = repairProductRepository.getRepairProductById(deleteRepairProductRequest.getProductId());
        if (repairProduct.isPresent()){
            repairProductRepository.deleteRepairProductById(repairProduct.get());
        }
        return DeleteRepairProductResponse.of().deleteRepairProductRequest(deleteRepairProductRequest).build();
    }

    @Override
    public UpdateRepairProductResponse updateRepairProduct(UpdateRepairProductRequest updateRepairProductRequest) {
        Optional<RepairProduct> repairProduct = repairProductRepository.getRepairProductById(updateRepairProductRequest.getProductId());
        if(repairProduct.get().getIsApproved()==null) {
            repairProduct.get().setIsApproved("approved");
            repairProductRepository.save(repairProduct.get());
        }else{
            repairProductRepository.save(repairProduct.get());
        }
        return UpdateRepairProductResponse.of().updateRepairProductRequest(updateRepairProductRequest).build();


    }

    public List<RepairProductDTO> getRepairProducts() {
        List<RepairProduct> repairProducts = repairProductRepository.getRepairProducts();
        return repairProducts.stream().map(rp -> RepairProductAssembler.toDTO(rp)).collect(Collectors.toList());
    }
}
