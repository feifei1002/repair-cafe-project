package uk.cf.ac.nccteam11.service;

import uk.cf.ac.nccteam11.forms.Product;
import uk.cf.ac.nccteam11.forms.ProductListRequest;
import uk.cf.ac.nccteam11.forms.ProductListResponse;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getProducts();
    List<Product> getProductsBySearch(String search);
    Optional<Product> getProductsByLocation(String location);
    Optional<Product> getProductByDescription(String description);
    Optional<Product> getProductByCategory(String category);


}
