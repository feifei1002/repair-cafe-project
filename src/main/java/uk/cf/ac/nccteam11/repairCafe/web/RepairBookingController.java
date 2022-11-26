package uk.cf.ac.nccteam11.repairCafe.web;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.cf.ac.nccteam11.repairCafe.service.RepairBookingService;
import uk.cf.ac.nccteam11.repairCafe.service.RepairBookingDTO;
import uk.cf.ac.nccteam11.repairCafe.service.RepairCafeService;
import uk.cf.ac.nccteam11.repairCafe.service.message.*;
import java.util.List;

@Controller
public class RepairBookingController {

    private final RepairBookingService repairBookingService;
    private final RepairCafeService repairCafeService;

    public RepairBookingController(RepairBookingService rbs, RepairCafeService rcs) {
        this.repairBookingService = rbs;
        this.repairCafeService = rcs;
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
        RepairCafeListRequest repairCafeListRequest = RepairCafeListRequest.of().build();
        var repairCafeListResponse = repairCafeService.getRepairCafes(repairCafeListRequest);
        model.addAttribute("repairCafes", repairCafeListResponse.getRepairCafes());
        var mv = new ModelAndView("repair-form", model.asMap());
        return mv;
    }

    @PostMapping("repair/booking/add")
    public ModelAndView addNewRepairBooking(RepairBookingForm newRepairBooking, BindingResult bindingResult, Model model) {
        RepairBookingDTO repairBookingDTO = new RepairBookingDTO(newRepairBooking.getBooking_id(), newRepairBooking.getFirstName(), newRepairBooking.getLastName(), newRepairBooking.getEmail(), newRepairBooking.getRepairDate(), newRepairBooking.getLocation());
        SaveRepairBookingRequest saveRepairBookingRequest = SaveRepairBookingRequest.of().repairBookingDTO(repairBookingDTO).build();
        SaveRepairBookingResponse saveRepairBookingResponse = repairBookingService.addNewRepairBooking(saveRepairBookingRequest);
        var mv = new ModelAndView("repair-booking-list");
        System.out.println("Booking successfully added");
        return mv;
    }

    @GetMapping("repair/bookings")
    public ResponseEntity<List<RepairBookingDTO>> getAllRepairBookings() {
        RepairBookingListRequest repairBookingListRequest = RepairBookingListRequest.of().build();
        RepairBookingListResponse repairBookingListResponse = repairBookingService.getRepairBookings(repairBookingListRequest);


        return ResponseEntity.ok(repairBookingListResponse.getRepairBookings());
    }
}
