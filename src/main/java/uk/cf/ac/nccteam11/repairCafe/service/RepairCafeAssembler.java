package uk.cf.ac.nccteam11.repairCafe.service;

import uk.cf.ac.nccteam11.repairCafe.domain.RepairCafe;

import java.util.List;
import java.util.stream.Collectors;

public class RepairCafeAssembler {
    static List<RepairCafeDTO> toDTO(List<RepairCafe> repairCafes) {
        return repairCafes
                .stream()
                .map(c -> new RepairCafeDTO(c.getName(), c.getCafe_id(), c.getAddress()))
                .collect(Collectors.toList());
    }
}
