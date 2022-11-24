package uk.cf.ac.nccteam11.repairCafe.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("repair-booking-list")
    public ModelAndView getRepairBookings(Model model) {

        List<RepairBookingDTO> repairBookings = repairBookingService.getRepairBookings();

        model.addAttribute("repairBookings", repairBookings);

        var mv = new ModelAndView("repair-booking-list", model.asMap());
        return mv;

    }

    @GetMapping("repair/booking")
    public ModelAndView getNewRepairForm(Model model) {
        model.addAttribute("repairBookingForm", new RepairBookingForm());
        var mv = new ModelAndView("repairBookingForm", model.asMap());
        return mv;
    }

    @PostMapping("repair/booking")
    public ModelAndView processNewRepairForm(RepairBookingForm newBooking, Model model) {
        RepairBookingDTO repairBookingDTO = new RepairBookingDTO(newBooking.getFirstName(), newBooking.getLastName(), newBooking.getEmail(), newBooking.getRepairDate(), newBooking.getLocation());
        repairBookingService.addNewRepairBooking(repairBookingDTO);
        var mv = new ModelAndView("redirect:/repair/booking");
        return mv;
    }

    private List<RepairBookingDTO> getRepairBookings() {
        return repairBookingService.getRepairBookings();
    }
}
