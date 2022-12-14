package uk.cf.ac.nccteam11.repairCafe.web;

import uk.cf.ac.nccteam11.repairCafe.service.RepairBorrowDTO;
import uk.cf.ac.nccteam11.repairCafe.service.RepairCafeDTO;

public class FormAssembler {
    public static RepairCafeAddForm toRepairCafeAddForm(RepairCafeDTO repairCafeDTO) {
        return new RepairCafeAddForm(repairCafeDTO.getCafeId(), repairCafeDTO.getName(), repairCafeDTO.getAddress(), repairCafeDTO.getCity(), repairCafeDTO.getPostcode());
    }
    public static RepairCafeDTO toRepairCafeDTO(RepairCafeAddForm repairCafeAdd) {
        return new RepairCafeDTO(repairCafeAdd.getCafeId(), repairCafeAdd.getName(), repairCafeAdd.getAddress(), repairCafeAdd.getCity(), repairCafeAdd.getPostcode());
    }

    public static RepairProductBorrowForm toRepairBorrowForm(RepairBorrowDTO repairBorrowDTO) {
        return new RepairProductBorrowForm(repairBorrowDTO.getBorrowId(), repairBorrowDTO.getFirstName(),
                repairBorrowDTO.getLastName(), repairBorrowDTO.getEmail(), repairBorrowDTO.getProductName(), repairBorrowDTO.getProductId());
    }

    public static RepairBorrowDTO toRepairBorrowDTO(RepairProductBorrowForm repairBorrowAdd){
        return new RepairBorrowDTO(repairBorrowAdd.getBorrowId(), repairBorrowAdd.getFirstName(), repairBorrowAdd.getLastName(), repairBorrowAdd.getEmail(), repairBorrowAdd.getProductName(), repairBorrowAdd.getProductId());
    }
}
