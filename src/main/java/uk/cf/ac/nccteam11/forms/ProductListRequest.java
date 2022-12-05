package uk.cf.ac.nccteam11.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;
import java.util.Optional;

@Value
@AllArgsConstructor
@Builder(builderMethodName = "of")
public class ProductListRequest {
    private Optional<String> searchTerm;
    private List<String> orderBy;
    private Integer limit;

}
