//package uk.cf.ac.nccteam11;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//import uk.cf.ac.nccteam11.repairCafe.service.*;
//import uk.cf.ac.nccteam11.repairCafe.service.message.RepairCafeListRequest;
//import uk.cf.ac.nccteam11.repairCafe.service.message.RepairCategoryListRequest;
//import uk.cf.ac.nccteam11.repairCafe.service.message.SaveRepairBookingRequest;
//import uk.cf.ac.nccteam11.repairCafe.service.message.SaveRepairBookingResponse;
//import uk.cf.ac.nccteam11.repairCafe.web.RepairBookingController;
//
//import java.sql.Date;
//import java.util.List;
//
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@WebMvcTest(controllers = RepairBookingController.class)
//
//public class RepairBookingWebMvcTests {
//    @Autowired
//    MockMvc mvc;
//
//    @MockBean
//    RepairBookingService repairBookingService;
//    @MockBean
//    RepairCafeService repairCafeService;
//    @MockBean
//    RepairCategoryService repairCategoryService;
//    @MockBean
//    EmailService emailService;
//
//    @BeforeEach
//    public void setUpStandingData() throws Exception{
//        RepairCategoryDTO category1 = new RepairCategoryDTO(1, "Furniture");
//        RepairCategoryDTO category2 = new RepairCategoryDTO(2, "Heater");
//        RepairCategoryDTO category3 = new RepairCategoryDTO(3, "Scooter");
//
//        RepairCafeDTO cafe1 = new RepairCafeDTO(1, "Bangor", "Bryncethin Community Centre, Ogmore Terrace, Bryncethin", "Bridgend", "CF32 9YF");
//        RepairCafeDTO cafe2 = new RepairCafeDTO(2, "Caerau", "Caerau Menshed, Bangor Terrace, Nantyffyllon", "Bridgend", "CF34 0HU");
//        RepairCafeDTO cafe3 = new RepairCafeDTO(3, "Caerphilly", "Caerphilly Miners Centre For The Community, Watford Road", "Caerphilly", "CF83 1ET");
//
//        RepairCategoryListRequest repairCategoryListRequest = RepairCategoryListRequest.of().build();
//        var repairCategoryListResponse = repairCategoryService.getRepairCategories(repairCategoryListRequest);
//        given(repairCategoryService.getRepairCategories(repairCategoryListRequest)).willReturn(repairCategoryListResponse.of().repairCategories(List.of(category1, category2, category3)).build());
//
//        RepairCafeListRequest repairCafeListRequest = RepairCafeListRequest.of().build();
//        var repairCafeListResponse = repairCafeService.getRepairCafes(repairCafeListRequest);
//        given(repairCafeService.getRepairCafes(repairCafeListRequest)).willReturn(repairCafeListResponse.of().repairCafes(List.of(cafe1, cafe2, cafe3)).build());
//
//    }
//
//    @Test
//    public void shouldAddANewRepairBooking() throws Exception {
//        //GIVEN
//        RepairBookingDTO newRepairBooking = new RepairBookingDTO(4, "Fei", "Liu", "liufei20021002@gmail.com", Date.valueOf("2022-02-12"), "Bicycle", "Bangor");
//
//        //WHEN
//        SaveRepairBookingRequest saveRepairBookingRequest = SaveRepairBookingRequest.of().repairBookingDTO(newRepairBooking).build();
//        SaveRepairBookingResponse saveRepairBookingResponse = SaveRepairBookingResponse.of().saveRepairBookingRequest(saveRepairBookingRequest).build();
//        given(repairBookingService.addNewRepairBooking(saveRepairBookingRequest)).willReturn(saveRepairBookingResponse);
//
//        //THEN
//        mvc.perform(post("/repair/booking/add")).andExpect(status().is2xxSuccessful());
//    }
//
//}
