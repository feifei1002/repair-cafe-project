package uk.cf.ac.nccteam11.repairCafe.service.message;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(builderMethodName = "of")
public class SingleRepairProductRequest {
    private final Integer product_id;
}
