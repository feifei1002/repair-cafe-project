package uk.cf.ac.nccteam11.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@AllArgsConstructor
@Builder(builderMethodName = "of")
public class ProductListResponse {
    private ProductListRequest request;
    private List<Product> products;
}
