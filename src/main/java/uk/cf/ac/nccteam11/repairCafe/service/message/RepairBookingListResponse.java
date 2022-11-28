package uk.cf.ac.nccteam11.repairCafe.service.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import uk.cf.ac.nccteam11.repairCafe.service.RepairBookingDTO;

import java.util.List;

@Value
@AllArgsConstructor
@Builder(builderMethodName="of")

public class RepairBookingListResponse {
    private RepairBookingListRequest request;
    private List<RepairBookingDTO> repairBookings;
}
