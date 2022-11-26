package uk.cf.ac.nccteam11.repairCafe.web;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.cf.ac.nccteam11.repairCafe.domain.RepairBooking;
import uk.cf.ac.nccteam11.repairCafe.service.RepairBookingAssembler;
import uk.cf.ac.nccteam11.repairCafe.service.RepairBookingService;
import uk.cf.ac.nccteam11.repairCafe.service.RepairBookingDTO;
import uk.cf.ac.nccteam11.repairCafe.service.message.RepairBookingListRequest;
import uk.cf.ac.nccteam11.repairCafe.service.message.RepairBookingListResponse;

import java.util.List;

@Controller
public class RepairBookingController {

    private final RepairBookingService repairBookingService;

    public RepairBookingController(RepairBookingService svc) {
        this.repairBookingService = svc;
    }

    @GetMapping("repair-booking-list")
    public ModelAndView getRepairBookings(Model model) {

        RepairBookingListRequest repairBookingListRequest = RepairBookingListRequest.of().build();
        var repairBookingListResponse = repairBookingService.getRepairBookings(repairBookingListRequest);

        model.addAttribute("repairBookings", repairBookingListResponse.getRepairBookings());

        var mv = new ModelAndView("repair-booking-list", model.asMap());
        return mv;

    }

    @GetMapping("repair/booking/form")
    public ModelAndView getNewRepairForm(Model model) {
        model.addAttribute("repairBookingForm", new RepairBookingForm());
        var mv = new ModelAndView("repair-form", model.asMap());
        return mv;
    }

    @PostMapping("repair/booking/add")
    public ModelAndView processNewRepairForm(Model model) {
        model.addAttribute("repairBookingForm", new RepairBookingForm());
        var mv = new ModelAndView("repair-form", model.asMap());
        return mv;
    }

    @GetMapping("repair/bookings")
    public ResponseEntity<List<RepairBookingDTO>> getAllRepairBookings() {
        RepairBookingListRequest repairBookingListRequest = RepairBookingListRequest.of().build();
        RepairBookingListResponse repairBookingListResponse = repairBookingService.getRepairBookings(repairBookingListRequest);


        return ResponseEntity.ok(repairBookingListResponse.getRepairBookings());
    }
}
