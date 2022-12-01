package uk.cf.ac.nccteam11.service;

import org.springframework.stereotype.Service;
import uk.cf.ac.nccteam11.forms.Product;
import uk.cf.ac.nccteam11.data.ProductRepo;
import uk.cf.ac.nccteam11.forms.ProductListRequest;
import uk.cf.ac.nccteam11.forms.ProductListResponse;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo repo){
        productRepo = repo;
    }

    /**
     * @param productListRequest
     * @return
     */
    public ProductListResponse getProducts(ProductListRequest productListRequest) {

        List<Product> products;

        if (productListRequest.getSearchTerm().isPresent()) {
            products = getProductsBySearch(productListRequest.getSearchTerm().get());
        } else {
            products = getProducts();
        }

        return ProductListResponse
                .of()
                .request(productListRequest)
                .products(products)
                .build();
    }

    private List<Product> getProducts() {
        List<Product> products = productRepo.getProducts();
        return products;
    }


    private List<Product> getProductsBySearch(String search) {
        List<Product> products = productRepo.getProductsBySearch(search);

        return products;
    }

    /**
     * @param location
     * @return
     */

    /**
     * @param description
     * @return
     */
    @Override
    public Optional<Product> getProductByDescription(String description) {
        return Optional.empty();
    }

    /**
     * @param category
     * @return
     */
    @Override
    public Optional<Product> getProductByCategory(String category) {
        return Optional.empty();
    }

    public Optional<ProductDto> getProductsByLocation(String location) {
        Optional<Product> aProduct = productRepo.getProductByLocation(location);
        if (aProduct.isPresent()) {
            System.out.println(aProduct.get());
            return Optional.of(ProductAssembler.toDto(aProduct.get()));
        } else {
            return Optional.empty();
        }
    }
}
