package uk.cf.ac.nccteam11.forms;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uk.cf.ac.nccteam11.service.ProductDto;
import uk.cf.ac.nccteam11.service.ProductService;

import java.util.List;
import java.util.Optional;
@Controller

public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService pvc) {
        this.productService = pvc;
    }

    @GetMapping("admin")
    public ModelAndView getProductListPage(@RequestParam(name = "search", required = false) Optional<String> query, Model model) {

        List<ProductDto> products;

        if(query.isPresent()) {
            products = getProductsBySearch(query.get());
        } else {
            products = getProducts();
        }

        model.addAttribute("products", products);

        var mv = new ModelAndView("admin", model.asMap());
        return mv;
    }

    private List<ProductDto> getProducts(){
        return productService.getProducts();
    }

    private List<ProductDto> getProductsBySearch(String search){
        return productService.getProductsBySearch(search);
    }
}
