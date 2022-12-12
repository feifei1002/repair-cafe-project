package uk.cf.ac.nccteam11.service;

import org.springframework.stereotype.Service;
import uk.cf.ac.nccteam11.forms.Product;
import uk.cf.ac.nccteam11.data.ProductRepo;
import uk.cf.ac.nccteam11.forms.ProductListRequest;
import uk.cf.ac.nccteam11.forms.ProductListResponse;
import uk.cf.ac.nccteam11.service.ProductDto;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo repo){
        productRepo = repo;
    }


    public List<ProductDto> getProducts() {

        List<Product> products = productRepo.getProducts();
        return ProductAssembler.toDto(products);

    }


    @Override
    public List<ProductDto> getProductsBySearch(String search) {
        List<Product> products = productRepo.getProductsBySearch(search);

        return ProductAssembler.toDto(products);
    }

    /**
     * @param description
     * @return
     */
    @Override
    public Optional<ProductDto> getProductByDescription(String description) {
        Optional<Product> aProduct = productRepo.getProductsByDescription(description);
        if (aProduct.isPresent()) {
            return Optional.of(ProductAssembler.toDto(aProduct.get()));
        } else {
            return Optional.empty();
        }
    }

    /**
     * @param category
     * @return
     */
    @Override
    public Optional<ProductDto> getProductByCategory(String category) {
        Optional<Product> aProduct = productRepo.getProductByCategory(category);
        if (aProduct.isPresent()) {
            return Optional.of(ProductAssembler.toDto(aProduct.get()));
        } else {
            return Optional.empty();
        }
    }


    /**
     * @param location
     * @return
     */


    @Override
    public Optional<ProductDto> getProductsByLocation(String location) {
        Optional<Product> aProduct = productRepo.getProductsByLocation(location);
        if (aProduct.isPresent()) {
            System.out.println(aProduct.get());
            return Optional.of(ProductAssembler.toDto(aProduct.get()));
        } else {
            return Optional.empty();
        }
    }
}
