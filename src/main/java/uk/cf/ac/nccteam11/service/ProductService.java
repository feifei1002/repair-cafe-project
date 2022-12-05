package uk.cf.ac.nccteam11.service;

import uk.cf.ac.nccteam11.forms.Product;
import uk.cf.ac.nccteam11.forms.ProductListRequest;
import uk.cf.ac.nccteam11.forms.ProductListResponse;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ProductDto> getProducts();
    List<ProductDto> getProductsBySearch(String search);
    Optional<ProductDto> getProductsByLocation(String location);
    Optional<ProductDto> getProductByDescription(String description);
    Optional<ProductDto> getProductByCategory(String category);


}
