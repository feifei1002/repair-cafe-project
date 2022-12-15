package uk.cf.ac.nccteam11.repairCafe.web;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uk.cf.ac.nccteam11.repairCafe.service.RepairCategoryDTO;
import uk.cf.ac.nccteam11.repairCafe.service.RepairCategoryService;
import uk.cf.ac.nccteam11.repairCafe.service.message.RepairCategoryListRequest;
import uk.cf.ac.nccteam11.repairCafe.service.message.RepairCategoryListResponse;

import java.util.List;

@Controller

public class RepairCategoryController {

    private final RepairCategoryService repairCategoryService;

    public RepairCategoryController(RepairCategoryService svc) {
        this.repairCategoryService = svc;
    }


    @GetMapping("repair/category-list")
    public ModelAndView getRepairCategories(@RequestParam(name = "q", required = false) String query, Model model) {

        RepairCategoryListRequest repairCategoryListRequest = RepairCategoryListRequest
                .of()
                .searchTerm(query)
                .build();

        var repairCategoryListResponse = repairCategoryService.getRepairCategories(repairCategoryListRequest);
        model.addAttribute("repairCategories", repairCategoryListResponse.getRepairCategories());
        var mv = new ModelAndView("category", model.asMap());
        return mv;
    }

    @GetMapping("repair/categories")
    private ResponseEntity<List<RepairCategoryDTO>> getAllRepairCategories() {
        RepairCategoryListRequest repairCategoryListRequest = RepairCategoryListRequest.of().build();
        RepairCategoryListResponse repairCategoryListResponse = repairCategoryService.getRepairCategories(repairCategoryListRequest);
        return ResponseEntity.ok(repairCategoryListResponse.getRepairCategories());
    }
}

