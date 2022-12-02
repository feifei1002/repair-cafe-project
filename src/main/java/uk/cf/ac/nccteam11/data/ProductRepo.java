package uk.cf.ac.nccteam11.data;

import uk.cf.ac.nccteam11.forms.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepo {
    List<Product> getProducts();
    Optional<Product> getProductsByByLocation(String location);
    List<Product> getProductsBySearch(String search);

    Optional<Product> getProductsByDescription(String description);

    Optional<Product> getProductsByLocation(String location);

    Optional<Product> getProductByCategory(String category);
}
