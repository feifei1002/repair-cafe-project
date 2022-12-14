package uk.cf.ac.nccteam11.repairCafe.web;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uk.cf.ac.nccteam11.repairCafe.service.RepairBorrowDTO;
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
    @GetMapping("repair-product/add")
    public ModelAndView getNewRepairProductAddForm(Model model){
        model.addAttribute("rentForm", new RepairProductRentForm());
        var mv = new ModelAndView("rent-form", model.asMap());
        return mv;
    }

    @PostMapping("repair-product/rent")
    public ModelAndView addNewRepairProduct(RepairProductRentForm newRepairProductAdd, BindingResult bindingResult, Model model){
//        if(bindingResult.hasErrors()){
//            SingleRepairProductRequest singleRepairProductRequest = SingleRepairProductRequest.of().productId(newRepairProductAdd.getProductId()).withBorrow(Boolean.FALSE).build();
//            var singleRepairProductResponse = repairProductService.getRepairProductByRequest(singleRepairProductRequest);
//            var repairProductDTO = singleRepairProductResponse.getRepairProductDTO();
//            var repairBorrowDTO = singleRepairProductResponse.getRepairBorrowDTO();
//            RepairProductBorrowForm repairBorrowForm = FormAssembler.toRepairBorrowForm(repairBorrowDTO);
//            model.addAttribute("repairBorrowForm", repairBorrowForm);
//            return new ModelAndView("/rent-form", model.asMap());
//        }else {
            RepairProductDTO repairProductDTO = new RepairProductDTO(newRepairProductAdd.getProductId(), newRepairProductAdd.getProductName(), newRepairProductAdd.getCondition(), newRepairProductAdd.getBrand(), newRepairProductAdd.getStatus(), newRepairProductAdd.getIsApproved());
            SaveRepairProductRequest saveRepairProductRequest = SaveRepairProductRequest.of().repairProductDTO(repairProductDTO).build();
            SaveRepairProductResponse saveRepairProductResponse = repairProductService.addNewRepairProduct(saveRepairProductRequest);
            var mv = new ModelAndView("redirect:/");
            return mv;
//        }
    }

    @GetMapping("repair-product/borrow")
        public ModelAndView getNewProductBorrowForm(Model model){
            model.addAttribute("borrowForm", new RepairProductBorrowForm());
            var mv = new ModelAndView("borrow-form");
            return mv;
    }

    @PostMapping("repair-product/{productId}/borrow")
    public ModelAndView addNewRepairBorrow (@PathVariable Integer productId, RepairProductBorrowForm newRepairBorrowAdd, Model model){
        RepairBorrowDTO repairBorrowDTO = FormAssembler.toRepairBorrowDTO(newRepairBorrowAdd);
        UpdateRepairBorrowRequest updateRepairBorrowRequest = UpdateRepairBorrowRequest.of().productId(productId).repairBorrowDTO(repairBorrowDTO).build();
        UpdateRepairBorrowResponse updateRepairBorrowResponse = repairProductService.updateRepairBorrow(updateRepairBorrowRequest);

        var mv = new ModelAndView("borrow-form", model.asMap());
        return mv;
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
