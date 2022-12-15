package uk.cf.ac.nccteam11.repairCafe.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uk.cf.ac.nccteam11.repairCafe.service.RepairProductDTO;
import uk.cf.ac.nccteam11.repairCafe.service.RepairProductService;
import uk.cf.ac.nccteam11.repairCafe.service.message.*;


import java.util.List;


@Controller
public class RepairProductController {

    private final RepairProductService repairProductService;

    public RepairProductController(RepairProductService svc) {
        this.repairProductService = svc;
    }


    @GetMapping("repair/product-list")
    public ModelAndView getRepairProducts(@RequestParam(name = "q", required = false) String query, Model model) {

        RepairProductListRequest repairProductListRequest = RepairProductListRequest
                .of()
                .searchTerm(query)
                .build();

        var repairProductListResponse = repairProductService.getRepairProducts(repairProductListRequest);
        model.addAttribute("repairProducts", repairProductListResponse.getRepairProducts());
        var mv = new ModelAndView("products-list", model.asMap());
        return mv;
    }

    @GetMapping("repair/products")
    private ResponseEntity<List<RepairProductDTO>> getAllRepairProducts() {
        RepairProductListRequest repairProductListRequest = RepairProductListRequest.of().build();
        RepairProductListResponse repairProductListResponse = repairProductService.getRepairProducts(repairProductListRequest);
        return ResponseEntity.ok(repairProductListResponse.getRepairProducts());
    }

    @GetMapping("repair/product/{product_id}")
    public ModelAndView getRepairProductByRequest(@PathVariable Integer product_id, Model model) {

        var singleRepairProductRequest = SingleRepairProductRequest

                .of()
                .product_id(product_id)
                .build();


        var singleRepairProductResponse = repairProductService.getRepairProductByRequest(singleRepairProductRequest);
        var repairProductDTO = singleRepairProductResponse.getRepairProductDTO();
        var mv = new ModelAndView("product-profile", model.asMap());
        return mv;

    }

    @GetMapping("category/{repair_Category_category_id}")
    public String getRepairProductsByCategoryId(@PathVariable int repair_Category_category_id, Model model) {
        List<RepairProduct> products = repairProductRepoJdbc.findByCategoryId(repair_Category_category_id);
        model.addAttribute("repairProduct", repairProducts);
        return "repairProducts";
    }
}

