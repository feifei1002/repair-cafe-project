package uk.cf.ac.nccteam11.repairCafe.web;

import uk.cf.ac.nccteam11.repairCafe.service.RepairCafeDTO;

public class FormAssembler {
    public static RepairCafeAddForm toRepairCafeAddForm(RepairCafeDTO repairCafeDTO) {
        return new RepairCafeAddForm(repairCafeDTO.getCafeId(), repairCafeDTO.getName(), repairCafeDTO.getAddress(), repairCafeDTO.getCity(), repairCafeDTO.getPostcode());
    }
    public static RepairCafeDTO toRepairCafeDTO(RepairCafeAddForm repairCafeAdd) {
        return new RepairCafeDTO(repairCafeAdd.getCafeId(), repairCafeAdd.getName(), repairCafeAdd.getAddress(), repairCafeAdd.getCity(), repairCafeAdd.getPostcode());
    }
}
