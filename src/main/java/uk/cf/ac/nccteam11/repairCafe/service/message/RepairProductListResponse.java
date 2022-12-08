package uk.cf.ac.nccteam11.repairCafe.service.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import uk.cf.ac.nccteam11.repairCafe.service.RepairProductDTO;
import java.util.List;

@Value
@AllArgsConstructor
@Builder(builderMethodName = "of")

public class RepairProductListResponse {
    private RepairProductListRequest request;
    private List<RepairProductDTO> repairProducts;
}
