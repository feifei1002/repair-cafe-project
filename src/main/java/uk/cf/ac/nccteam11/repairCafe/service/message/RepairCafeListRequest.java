package uk.cf.ac.nccteam11.repairCafe.service.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;
import java.util.Optional;

@Value
@AllArgsConstructor
@Builder(builderMethodName = "of")
public class RepairCafeListRequest {
    private Optional<String> searchTerm;
    private List<String> orderBy;
    private Integer limit;

    public Boolean hasSearchTerm() {
        return searchTerm.isPresent();
    }

    public String getSearchTermString() {
        return searchTerm.get();
    }
}
