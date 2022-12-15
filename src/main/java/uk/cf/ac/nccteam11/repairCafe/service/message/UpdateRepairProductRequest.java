package uk.cf.ac.nccteam11.repairCafe.service.message;

import lombok.Builder;
import lombok.Value;
import uk.cf.ac.nccteam11.repairCafe.service.RepairProductDTO;

@Value
@Builder(builderMethodName = "of")
public class UpdateRepairProductRequest {
    private final Integer product_id;
    private final RepairProductDTO repairProductDTO;
}