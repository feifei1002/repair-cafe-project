package uk.cf.ac.nccteam11.repairCafe.service.message;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import uk.cf.ac.nccteam11.repairCafe.domain.RepairCafe;
import uk.cf.ac.nccteam11.repairCafe.service.RepairCafeDTO;

import java.util.List;

@Value
@AllArgsConstructor
@Builder(builderMethodName="of")
public class RepairCafeListResponse {
    private RepairCafeListRequest request;
    private List<RepairCafeDTO> repairCafes;
}
