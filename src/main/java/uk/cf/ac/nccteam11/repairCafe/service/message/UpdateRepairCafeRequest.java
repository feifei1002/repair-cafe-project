package uk.cf.ac.nccteam11.repairCafe.service.message;

import lombok.Builder;
import lombok.Value;
import uk.cf.ac.nccteam11.repairCafe.service.RepairCafeDTO;

@Value
@Builder(builderMethodName = "of")
public class UpdateRepairCafeRequest {
    private final Integer cafe_id;
    private final RepairCafeDTO repairCafeDTO;
}
