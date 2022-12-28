package uk.cf.ac.nccteam11.repairCafe.web;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uk.cf.ac.nccteam11.repairCafe.service.RepairProductDTO;
import uk.cf.ac.nccteam11.repairCafe.service.RepairProductService;
import uk.cf.ac.nccteam11.repairCafe.service.message.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RepairProductController {

    private final RepairProductService repairProductService;

    public RepairProductController(RepairProductService svc) {
        this.repairProductService = svc;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("admin")
    public ModelAndView adminHomePage(Model model){
        return new ModelAndView("admin");
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("user/repair/products-list")
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

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("user/repair/product/{productId}")
    public ModelAndView getRepairProductByRequest(@PathVariable Integer productId, Model model) {

        var singleRepairProductRequest = SingleRepairProductRequest

                .of()
                .productId(productId)
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
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("user/repair-product/add")
    public ModelAndView getNewRepairProductAddForm(Model model){
        model.addAttribute("rentForm", new RepairProductRentForm());
        var mv = new ModelAndView("rent-form", model.asMap());
        return mv;
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PostMapping("user/repair-product/rent")
    public ModelAndView addNewRepairProduct(@Valid RepairProductRentForm newRepairProductAdd, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("rentForm", newRepairProductAdd);
            var mv= new ModelAndView("rent-form", model.asMap());
            return mv;
        }else {
            RepairProductDTO repairProductDTO = new RepairProductDTO(newRepairProductAdd.getProductId(), newRepairProductAdd.getProductName(), newRepairProductAdd.getCondition(), newRepairProductAdd.getBrand(), newRepairProductAdd.getStatus(), newRepairProductAdd.getIsApproved());
            SaveRepairProductRequest saveRepairProductRequest = SaveRepairProductRequest.of().repairProductDTO(repairProductDTO).build();
            SaveRepairProductResponse saveRepairProductResponse = repairProductService.addNewRepairProduct(saveRepairProductRequest);
            var mv = new ModelAndView("redirect:/");
            return mv;
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("admin/repair-products-list")
    public ModelAndView getRepairProductListPage(@RequestParam(name = "search", required = false) String query, Model model) {

       RepairProductListRequest repairProductListRequest = RepairProductListRequest.of().searchTerm(query).build();
       var repairProductListResponse = repairProductService.getRepairProducts(repairProductListRequest);

        model.addAttribute("products", repairProductListResponse.getRepairProducts());

        var mv = new ModelAndView("admin/repair-products-list", model.asMap());
        return mv;
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("admin/repair-product/{id}/update")
    public ModelAndView approveRepairProduct(@PathVariable("id") Integer productId, Model model){
        UpdateRepairProductRequest updateRepairProductRequest = UpdateRepairProductRequest.of().productId(productId).build();
        UpdateRepairProductResponse updateRepairProductResponse = repairProductService.updateRepairProduct(updateRepairProductRequest);
        var mv = new ModelAndView("redirect:/admin/repair-products-list");
        return mv;
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PostMapping("user/repair-product/{id}/status/update")
    public ModelAndView statusRepairProduct(@PathVariable("id") Integer productId, Model model){
        UpdateRepairProductRequest updateRepairProductRequest = UpdateRepairProductRequest.of().productId(productId).build();
        UpdateRepairProductResponse updateRepairProductResponse = repairProductService.updateRepairProductStatus(updateRepairProductRequest);
        var mv = new ModelAndView("redirect:/user/repair/products-list");
        return mv;
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("admin/repair-product/{id}/delete")
    public ModelAndView deleteRepairProduct(@PathVariable("id") Integer productId, Model model){
        DeleteRepairProductRequest deleteRepairProductRequest = DeleteRepairProductRequest.of().productId(productId).build();
        DeleteRepairProductResponse deleteRepairProductResponse = repairProductService.deleteRepairProduct(deleteRepairProductRequest);
        var mv = new ModelAndView("redirect:/admin/repair-products-list");
        return mv;
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("repair/products")
    private ResponseEntity<List<RepairProductDTO>> getAllRepairProducts() {
        RepairProductListRequest repairProductListRequest = RepairProductListRequest.of().build();
        RepairProductListResponse repairProductListResponse = repairProductService.getRepairProducts(repairProductListRequest);
        return ResponseEntity.ok(repairProductListResponse.getRepairProducts());

    }

}
