package uk.cf.ac.nccteam11.forms;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uk.cf.ac.nccteam11.service.ProductService;

import java.util.List;
import java.util.Optional;

public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService pvc) {
        this.productService = pvc;
    }

    @GetMapping
    public ModelAndView getProductListPage(@RequestParam(name = "search", required = false) Optional<String> query, Model model) {

        List<Product> product;

        ProductListRequest productListRequest = ProductListRequest
                .of()
                .searchTerm(query)
                .build();

        var productListResponse = productService.getProducts(productListRequest);

        model.addAttribute("products", productListResponse.getProducts());

        var mv = new ModelAndView("admin/admin", model.asMap());
        return mv;
    }
}
