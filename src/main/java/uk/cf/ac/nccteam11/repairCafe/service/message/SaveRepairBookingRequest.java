package uk.cf.ac.nccteam11.repairCafe.service.message;

import lombok.Builder;
import lombok.Value;
import uk.cf.ac.nccteam11.repairCafe.service.RepairBookingDTO;

@Value
@Builder(builderMethodName = "of")
public class SaveRepairBookingRequest {
    private final RepairBookingDTO repairBookingDTO;
}
