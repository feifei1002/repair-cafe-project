package uk.cf.ac.nccteam11.repairCafe.web;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import uk.cf.ac.nccteam11.repairCafe.service.*;
import uk.cf.ac.nccteam11.repairCafe.service.message.*;

import java.util.List;

@Controller
public class RepairBookingController {

    private final RepairBookingService repairBookingService;
    private final RepairCategoryService repairCategoryService;
    private final RepairCafeService repairCafeService;
    private EmailService emailService;

    public RepairBookingController(RepairBookingService rbs, RepairCategoryService rcates, RepairCafeService rcs, EmailService es) {
        this.repairBookingService = rbs;
        this.repairCategoryService = rcates;
        this.repairCafeService = rcs;
        this.emailService = es;
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

        RepairCategoryListRequest repairCategoryListRequest = RepairCategoryListRequest.of().build();
        var repairCategoryListResponse = repairCategoryService.getRepairCategories(repairCategoryListRequest);
        model.addAttribute("categories", repairCategoryListResponse.getRepairCategories());

        RepairCafeListRequest repairCafeListRequest = RepairCafeListRequest.of().build();
        var repairCafeListResponse = repairCafeService.getRepairCafes(repairCafeListRequest);
        model.addAttribute("repairCafes", repairCafeListResponse.getRepairCafes());

        var mv = new ModelAndView("repair-form", model.asMap());
        return mv;
    }

    @PostMapping("repair/booking/add")
    @ResponseBody
    public ModelAndView addNewRepairBooking(RepairBookingForm newRepairBooking, BindingResult bindingResult, Model model) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        RepairBookingDTO repairBookingDTO = new RepairBookingDTO(newRepairBooking.getBooking_id(), newRepairBooking.getFirstName(), newRepairBooking.getLastName(), newRepairBooking.getEmail(), newRepairBooking.getRepairDate(), newRepairBooking.getCategory(), newRepairBooking.getLocation());
//        RepairBookingDTO repairBookingDTO = new RepairBookingDTO(newRepairBooking.getBooking_id(), newRepairBooking.getFirstName(), newRepairBooking.getLastName(), newRepairBooking.getEmail(), Date.valueOf("2022-10-26"), newRepairBooking.getCategory(), newRepairBooking.getLocation());
        SaveRepairBookingRequest saveRepairBookingRequest = SaveRepairBookingRequest.of().repairBookingDTO(repairBookingDTO).build();
        SaveRepairBookingResponse saveRepairBookingResponse = repairBookingService.addNewRepairBooking(saveRepairBookingRequest);
        emailService.sendSimpleMail(newRepairBooking);
        var mv = new ModelAndView("redirect:/repair-booking-list");
        return mv;
    }

    @GetMapping("repair/bookings")
    public ResponseEntity<List<RepairBookingDTO>> getAllRepairBookings() {
        RepairBookingListRequest repairBookingListRequest = RepairBookingListRequest.of().build();
        RepairBookingListResponse repairBookingListResponse = repairBookingService.getRepairBookings(repairBookingListRequest);


        return ResponseEntity.ok(repairBookingListResponse.getRepairBookings());
    }
}
