package uk.cf.ac.nccteam11.repairCafe.web;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uk.cf.ac.nccteam11.repairCafe.service.RepairCategoryService;
import uk.cf.ac.nccteam11.repairCafe.service.RepairProductDTO;
import uk.cf.ac.nccteam11.repairCafe.service.RepairProductService;
import uk.cf.ac.nccteam11.repairCafe.service.message.RepairCategoryListRequest;
import uk.cf.ac.nccteam11.repairCafe.service.message.RepairProductListRequest;
import uk.cf.ac.nccteam11.repairCafe.service.message.RepairProductListResponse;
import uk.cf.ac.nccteam11.repairCafe.service.message.SingleRepairProductRequest;

import java.util.List;


@Controller
public class RepairProductController {

    private final RepairProductService repairProductService;
    private final RepairCategoryService repairCategoryService;

    public RepairProductController(RepairProductService svc, RepairCategoryService rcs) {
        this.repairProductService = svc;
        this.repairCategoryService = rcs;
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
        if(singleRepairProductResponse.isRepairProductPresent()){
            model.addAttribute("repairProducts", singleRepairProductResponse.getRepairProductDTO());
            var mv = new ModelAndView("product-profile", model.asMap());
            return mv;
        }
//        var repairProductDTO = singleRepairProductResponse.getRepairProductDTO();
        var mv = new ModelAndView("product-profile", model.asMap());
        return mv;

    }
    @GetMapping("category-list")
    public ModelAndView getCategoryList(Model model){
        RepairCategoryListRequest repairCategoryListRequest = RepairCategoryListRequest.of().build();
        var repairCategoryListResponse = repairCategoryService.getRepairCategories(repairCategoryListRequest);
        RepairProductListRequest repairProductListRequest = RepairProductListRequest
                .of()
                .build();

        var repairProductListResponse = repairProductService.getRepairProducts(repairProductListRequest);
        model.addAttribute("repairProducts", repairProductListResponse.getRepairProducts());
        model.addAttribute("repairCategories", repairCategoryListResponse.getRepairCategories());
        var mv = new ModelAndView("category", model.asMap());
        return mv;
    }

//    @GetMapping("category/{repair_Category_category_id}")
//    public String getRepairProductsByCategoryId(@PathVariable int repair_Category_category_id, Model model) {
//        List<RepairProduct> products = repairProductRepoJdbc.findByCategoryId(repair_Category_category_id);
//        model.addAttribute("repairProduct", repairProducts);
//        return "repairProducts";
//    }
}

