package uk.cf.ac.nccteam11.repairCafe.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.cf.ac.nccteam11.repairCafe.domain.RepairCafe;
import uk.cf.ac.nccteam11.repairCafe.service.RepairCafeService;

import java.util.List;

@Controller
public class RepairCafeController {

    private final RepairCafeService repairCafeService;

    public RepairCafeController(RepairCafeService svc) {
        this.repairCafeService = svc;
    }

    @GetMapping("repair-form")
    public ModelAndView getRepairCafes(Model model) {

        List<RepairCafe> repairCafes = repairCafeService.getRepairCafes();

        model.addAttribute("repairCafes", repairCafes);

        var mv = new ModelAndView("repair-form", model.asMap());
        return mv;

    }

    private List<RepairCafe> getRepairCafes() {
        return repairCafeService.getRepairCafes();
    }
}
