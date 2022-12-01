package uk.cf.ac.nccteam11.service;

import uk.cf.ac.nccteam11.forms.ProductListRequest;
import uk.cf.ac.nccteam11.forms.ProductListResponse;

public interface ProductService {
    ProductListResponse getProducts(ProductListRequest productListRequest);
}
