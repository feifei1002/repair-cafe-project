package uk.cf.ac.nccteam11.repairCafe.web;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.cf.ac.nccteam11.repairCafe.service.*;
import uk.cf.ac.nccteam11.repairCafe.service.message.*;

import javax.validation.Valid;
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

    @GetMapping("admin/repair-booking-list")
    public ModelAndView getRepairBookings(Model model) {

        RepairBookingListRequest repairBookingListRequest = RepairBookingListRequest.of().build();
        var repairBookingListResponse = repairBookingService.getRepairBookings(repairBookingListRequest);

        model.addAttribute("repairBookings", repairBookingListResponse.getRepairBookings());

        var mv = new ModelAndView("repair-booking-list", model.asMap());
        return mv;

    }

    @GetMapping("repair/booking/form")
    @ModelAttribute
    public ModelAndView getNewRepairForm(Model model) {
        model.addAttribute("repairBookingForm", new RepairBookingForm());
        var mv = new ModelAndView("repair-form", model.asMap());
        return mv;
    }

    @PostMapping("repair/booking/add")
    @ModelAttribute
    public ModelAndView addNewRepairBooking(@Valid RepairBookingForm newRepairBooking, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            var mv = new ModelAndView("repair-form", model.asMap());
            return mv;
        } else {
            RepairBookingDTO repairBookingDTO = new RepairBookingDTO(newRepairBooking.getBooking_id(), newRepairBooking.getFirstName(), newRepairBooking.getLastName(), newRepairBooking.getEmail(), newRepairBooking.getRepairDate(), newRepairBooking.getCategory(), newRepairBooking.getLocation());
            SaveRepairBookingRequest saveRepairBookingRequest = SaveRepairBookingRequest.of().repairBookingDTO(repairBookingDTO).build();
            SaveRepairBookingResponse saveRepairBookingResponse = repairBookingService.addNewRepairBooking(saveRepairBookingRequest);
            emailService.sendSimpleMail(newRepairBooking);
            var mv = new ModelAndView("redirect:/");
            return mv;
        }
    }

    @GetMapping("repair/bookings")
    public ResponseEntity<List<RepairBookingDTO>> getAllRepairBookings() {
        RepairBookingListRequest repairBookingListRequest = RepairBookingListRequest.of().build();
        RepairBookingListResponse repairBookingListResponse = repairBookingService.getRepairBookings(repairBookingListRequest);


        return ResponseEntity.ok(repairBookingListResponse.getRepairBookings());
    }

    @ModelAttribute("categories")
    public List<RepairCategoryDTO> repairCategories(Model model) {
        RepairCategoryListRequest repairCategoryListRequest = RepairCategoryListRequest.of().build();
        var repairCategoryListResponse = repairCategoryService.getRepairCategories(repairCategoryListRequest);
        return repairCategoryListResponse.getRepairCategories();
    }

    @ModelAttribute("repairCafes")
    public List<RepairCafeDTO> repairCafes(Model model) {
        RepairCafeListRequest repairCafeListRequest = RepairCafeListRequest.of().build();
        var repairCafeListResponse = repairCafeService.getRepairCafes(repairCafeListRequest);
        return repairCafeListResponse.getRepairCafes();
    }
}
