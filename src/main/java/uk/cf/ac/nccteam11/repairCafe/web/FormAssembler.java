package uk.cf.ac.nccteam11.repairCafe.web;

import uk.cf.ac.nccteam11.repairCafe.service.RepairCafeDTO;

public class FormAssembler {
    public static RepairCafeAddForm toRepairCafeAddForm(RepairCafeDTO repairCafeDTO) {
        return new RepairCafeAddForm(repairCafeDTO.getCafe_id(), repairCafeDTO.getName(), repairCafeDTO.getAddress(), repairCafeDTO.getCity(), repairCafeDTO.getPostcode());
    }
}
