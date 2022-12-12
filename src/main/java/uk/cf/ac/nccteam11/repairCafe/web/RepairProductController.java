package uk.cf.ac.nccteam11.repairCafe.web;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uk.cf.ac.nccteam11.repairCafe.service.RepairProductDTO;
import uk.cf.ac.nccteam11.repairCafe.service.RepairProductService;
import uk.cf.ac.nccteam11.repairCafe.service.message.RepairProductListRequest;
import uk.cf.ac.nccteam11.repairCafe.service.message.RepairProductListResponse;

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
    @GetMapping("repair/product-list")
    private ResponseEntity<List<RepairProductDTO>> getAllRepairProducts() {
        RepairProductListRequest repairProductListRequest = RepairProductListRequest.of().build();
        RepairProductListResponse repairProductListResponse = repairProductService.getRepairProducts(repairProductListRequest);
        return ResponseEntity.ok(repairProductListResponse.getRepairProducts());

    }

}
