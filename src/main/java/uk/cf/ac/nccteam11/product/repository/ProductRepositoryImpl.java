package uk.cf.ac.nccteam11.product.repository;

import org.springframework.stereotype.Repository;
import uk.cf.ac.nccteam11.product.domain.Product;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private final ProductRepositoryJdbc productRepoJdbc;
    public ProductRepositoryImpl(ProductRepositoryJdbc prRepoJdbc) {
        this.productRepoJdbc = prRepoJdbc;
    }

    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        productRepoJdbc.findAll().forEach(products::add);
        return products;
    }
}
