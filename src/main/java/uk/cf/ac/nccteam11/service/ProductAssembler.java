package uk.cf.ac.nccteam11.service;

import uk.cf.ac.nccteam11.forms.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductAssembler {
    static List<ProductDto> toDto(List<Product> products) {
        return products
                .stream()
                .map(p -> toDto(p))
                .collect(Collectors.toList());
    }

    public static ProductDto toDto(Product p) {
        return new ProductDto(p.getProductID(), p.getName(), p.getDescription(), p.getCategory(), p.getLocation(), p.getStatus(), p.getAvailability());
    }
}
