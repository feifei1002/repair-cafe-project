package uk.cf.ac.nccteam11.repairCafe.web;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uk.cf.ac.nccteam11.repairCafe.service.RepairCafeDTO;
import uk.cf.ac.nccteam11.repairCafe.service.RepairCafeService;
import uk.cf.ac.nccteam11.repairCafe.service.message.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RepairCafeController {

    private final RepairCafeService repairCafeService;

    public RepairCafeController(RepairCafeService svc) {
        this.repairCafeService = svc;
    }
    @GetMapping("/")
    public ModelAndView homePage(Model model){
        RepairCafeListRequest repairCafeListRequest = RepairCafeListRequest.of().build();
        var repairCafeListResponse = repairCafeService.getRepairCafes(repairCafeListRequest);
        model.addAttribute("repairCafes", repairCafeListResponse.getRepairCafes());
        return new ModelAndView("index");
    }

    @GetMapping("repair-cafes-list")
    public ModelAndView getRepairCafes(@RequestParam(name = "q", required = false) String query, Model model) {

        RepairCafeListRequest repairCafeListRequest = RepairCafeListRequest
                .of()
                .searchTerm(query)
                .build();

        var repairCafeListResponse = repairCafeService.getRepairCafes(repairCafeListRequest);
        model.addAttribute("repairCafes", repairCafeListResponse.getRepairCafes());
        var mv = new ModelAndView("repair-cafes-list", model.asMap());
        return mv;
    }

    @GetMapping("admin/repair-cafe/add/form")
    public ModelAndView getNewRepairCafeAddForm(Model model){
        model.addAttribute("repairCafeAdd", new RepairCafeAddForm());
        var mv = new ModelAndView("admin/repair-cafe-add", model.asMap());
        return mv;
    }

    @PostMapping("admin/repair-cafe/add")
    public ModelAndView addNewRepairCafe(@Valid RepairCafeAddForm newRepairCafeAdd, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            var mv = new ModelAndView("admin/repair-cafe-add", model.asMap());
            return mv;
        } else {
            RepairCafeDTO repairCafeDTO = new RepairCafeDTO(newRepairCafeAdd.getCafe_id(), newRepairCafeAdd.getName(), newRepairCafeAdd.getAddress(), newRepairCafeAdd.getCity(), newRepairCafeAdd.getPostcode());
            SaveRepairCafeRequest saveRepairCafeRequest = SaveRepairCafeRequest.of().repairCafeDTO(repairCafeDTO).build();
            SaveRepairCafeResponse saveRepairCafeResponse = repairCafeService.addNewRepairCafe(saveRepairCafeRequest);
            var mv = new ModelAndView("redirect:/repair-cafes-list");
            return mv;
        }
    }

    @GetMapping("admin/repair-cafe/delete/form")
    public ModelAndView getDeleteRepairCafeForm(Model model){
        model.addAttribute("repairCafeDelete", new RepairCafeDeleteForm());
        var mv = new ModelAndView("admin/repair-cafe-delete", model.asMap());
        return mv;
    }

    @PostMapping("admin/repair-cafe/delete")
    public ModelAndView deleteRepairCafe(@PathVariable("id") Integer cafeId, RepairCafeDeleteForm repairCafeDelete, Model model){
        DeleteRepairCafeRequest deleteRepairCafeRequest = DeleteRepairCafeRequest.of().cafeId(repairCafeDelete.getCafe_id()).build();
        DeleteRepairCafeResponse deleteRepairCafeResponse = repairCafeService.deleteRepairCafe(deleteRepairCafeRequest);
        var mv = new ModelAndView("redirect:/repair-cafes-list");
        return mv;
    }

    @GetMapping("repair/cafes")
    private ResponseEntity<List<RepairCafeDTO>> getAllRepairCafes() {
        RepairCafeListRequest repairCafeListRequest = RepairCafeListRequest.of().build();
        RepairCafeListResponse repairCafeListResponse = repairCafeService.getRepairCafes(repairCafeListRequest);
        return ResponseEntity.ok(repairCafeListResponse.getRepairCafes());
    }
}
