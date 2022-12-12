package uk.cf.ac.nccteam11.repairCafe.service;
import uk.cf.ac.nccteam11.repairCafe.domain.RepairProduct;

public class RepairProductAssembler {
    static RepairProductDTO toDTO(RepairProduct rp) {
        return new RepairProductDTO(rp.getProduct_id(), rp.getProductName(), rp.getCondition(), rp.getBrand(), rp.getStatus());
    }
}
