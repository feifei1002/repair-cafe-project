package uk.cf.ac.nccteam11.repairCafe.service;
import uk.cf.ac.nccteam11.repairCafe.domain.RepairBorrow;
import uk.cf.ac.nccteam11.repairCafe.domain.RepairProduct;

public class RepairProductAssembler {
    static RepairProductDTO toDTO(RepairProduct rp) {
        return new RepairProductDTO(rp.getProductId(), rp.getProductName(), rp.getCondition(), rp.getBrand(), rp.getStatus(), rp.getIsApproved());
    }

    public static RepairBorrowDTO toDTO(RepairBorrow rb) {
        return new RepairBorrowDTO(rb.getBorrowId(), rb.getFirstName(), rb.getLastName(), rb.getEmail());
    }
}
