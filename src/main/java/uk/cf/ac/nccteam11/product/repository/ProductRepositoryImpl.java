package uk.cf.ac.nccteam11.product.repository;

import org.springframework.stereotype.Repository;
import uk.cf.ac.nccteam11.product.domain.Product;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public List<Product> getProducts() {
        return null;
    }
}
