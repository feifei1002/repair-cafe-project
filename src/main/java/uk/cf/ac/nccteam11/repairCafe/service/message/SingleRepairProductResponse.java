package uk.cf.ac.nccteam11.repairCafe.service.message;

import lombok.Builder;
import lombok.Value;
import uk.cf.ac.nccteam11.repairCafe.service.RepairProductDTO;

@Value
@Builder(builderMethodName = "of")
public class SingleRepairProductResponse {
    private final SingleRepairProductRequest singleRepairProductRequest;
    private final RepairProductDTO repairProductDTO;
}
