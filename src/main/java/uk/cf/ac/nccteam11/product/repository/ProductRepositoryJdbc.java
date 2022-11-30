package uk.cf.ac.nccteam11.product.repository;

import org.springframework.data.repository.CrudRepository;
import uk.cf.ac.nccteam11.product.domain.Product;

public interface ProductRepositoryJdbc extends CrudRepository<Product, Integer> {
}
