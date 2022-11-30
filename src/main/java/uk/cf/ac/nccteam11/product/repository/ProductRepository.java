package uk.cf.ac.nccteam11.product.repository;

import uk.cf.ac.nccteam11.product.domain.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getProducts();
}
