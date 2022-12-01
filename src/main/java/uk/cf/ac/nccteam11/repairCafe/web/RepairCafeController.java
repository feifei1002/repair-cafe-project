package uk.cf.ac.nccteam11.repairCafe.web;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.cf.ac.nccteam11.repairCafe.service.RepairCafeDTO;
import uk.cf.ac.nccteam11.repairCafe.service.RepairCafeService;
import uk.cf.ac.nccteam11.repairCafe.service.message.RepairCafeListRequest;
import uk.cf.ac.nccteam11.repairCafe.service.message.RepairCafeListResponse;

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

    @GetMapping("repair-cafe-list")
    public ModelAndView getRepairCafes(Model model) {
        RepairCafeListRequest repairCafeListRequest = RepairCafeListRequest.of().build();
        var repairCafeListResponse = repairCafeService.getRepairCafes(repairCafeListRequest);
        model.addAttribute("repairCafes", repairCafeListResponse.getRepairCafes());
        var mv = new ModelAndView("repair-cafe-list", model.asMap());
        return mv;
    }

    @GetMapping("repair/cafes")
    private ResponseEntity<List<RepairCafeDTO>> getAllRepairCafes() {
        RepairCafeListRequest repairCafeListRequest = RepairCafeListRequest.of().build();
        RepairCafeListResponse repairCafeListResponse = repairCafeService.getRepairCafes(repairCafeListRequest);
        return ResponseEntity.ok(repairCafeListResponse.getRepairCafes());
    }
}
