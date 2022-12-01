package uk.cf.ac.nccteam11.repairCafe.service.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@AllArgsConstructor
@Builder(builderMethodName = "of")
public class RepairCafeListRequest {
    private String searchTerm;
    private List<String> orderBy;
    private Integer limit;
}
