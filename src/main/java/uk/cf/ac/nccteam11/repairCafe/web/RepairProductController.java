package uk.cf.ac.nccteam11.repairCafe.web;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("admin")
    public ModelAndView adminHomePage(Model model){
        return new ModelAndView("admin");
    }

    @GetMapping("admin/repair-products-list")
    public ModelAndView getRepairProductListPage(@RequestParam(name = "search", required = false) String query, Model model) {

       RepairProductListRequest repairProductListRequest = RepairProductListRequest.of().searchTerm(query).build();
       var repairProductListResponse = repairProductService.getRepairProducts(repairProductListRequest);

        model.addAttribute("products", repairProductListResponse.getRepairProducts());

        var mv = new ModelAndView("admin/repair-products-list", model.asMap());
        return mv;
    }
    @PostMapping("admin/repair-product/{id}/update")
    public ModelAndView approveRepairProduct(@PathVariable("id") Integer productId, Model model){
        UpdateRepairProductRequest updateRepairProductRequest = UpdateRepairProductRequest.of().productId(productId).build();
        UpdateRepairProductResponse updateRepairProductResponse = repairProductService.updateRepairProduct(updateRepairProductRequest);
        var mv = new ModelAndView("redirect:/admin/repair-products-list");
        return mv;
    }
    @PostMapping("admin/repair-product/{id}/delete")
    public ModelAndView deleteRepairProduct(@PathVariable("id") Integer productId, Model model){
        DeleteRepairProductRequest deleteRepairProductRequest = DeleteRepairProductRequest.of().productId(productId).build();
        DeleteRepairProductResponse deleteRepairProductResponse = repairProductService.deleteRepairProduct(deleteRepairProductRequest);
        var mv = new ModelAndView("redirect:/admin/repair-products-list");
        return mv;
    }
    @GetMapping("repair/product-list")
    private ResponseEntity<List<RepairProductDTO>> getAllRepairProducts() {
        RepairProductListRequest repairProductListRequest = RepairProductListRequest.of().build();
        RepairProductListResponse repairProductListResponse = repairProductService.getRepairProducts(repairProductListRequest);
        return ResponseEntity.ok(repairProductListResponse.getRepairProducts());

    }

}
