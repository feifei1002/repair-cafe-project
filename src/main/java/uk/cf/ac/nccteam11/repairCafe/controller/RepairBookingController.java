package uk.cf.ac.nccteam11.repairCafe.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.cf.ac.nccteam11.repairCafe.service.RepairBookingService;
import uk.cf.ac.nccteam11.repairCafe.service.RepairBookingDTO;

import java.util.List;

@Controller
public class RepairBookingController {

    private final RepairBookingService repairBookingService;

    public RepairBookingController(RepairBookingService svc) {
        this.repairBookingService = svc;
    }

    @GetMapping("repair/booking")
    public ModelAndView getRepairBookings(Model model) {

        List<RepairBookingDTO> repairBookings = repairBookingService.getRepairBookings();

        model.addAttribute("repairBookings", repairBookings);

        var mv = new ModelAndView("repair-form", model.asMap());
        return mv;

    }

    private List<RepairBookingDTO> getRepairBookings() {
        return repairBookingService.getRepairBookings();
    }
}
