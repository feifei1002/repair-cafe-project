package uk.cf.ac.nccteam11.repairCafe.service.message;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(builderMethodName = "of")
public class SaveRepairProductResponse {
    private final SaveRepairProductRequest saveRepairProductRequest;
}
