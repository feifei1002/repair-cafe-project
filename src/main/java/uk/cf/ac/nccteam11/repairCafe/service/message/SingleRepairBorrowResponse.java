package uk.cf.ac.nccteam11.repairCafe.service.message;

import lombok.Builder;
import lombok.Value;
import uk.cf.ac.nccteam11.repairCafe.service.RepairBorrowDTO;

@Value
@Builder(builderMethodName = "of")
public class SingleRepairBorrowResponse {
    private final SingleRepairBorrowRequest singleRepairBorrowRequest;
    private final RepairBorrowDTO repairBorrowDTO;
}
