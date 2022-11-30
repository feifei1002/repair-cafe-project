package uk.cf.ac.nccteam11;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import uk.cf.ac.nccteam11.repairCafe.service.*;
import uk.cf.ac.nccteam11.repairCafe.service.message.SaveRepairBookingRequest;
import uk.cf.ac.nccteam11.repairCafe.service.message.SaveRepairBookingResponse;
import uk.cf.ac.nccteam11.repairCafe.web.RepairBookingController;

import java.sql.Date;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = RepairBookingController.class)
@AutoConfigureMockMvc
public class WebMvcRepairBookingTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    RepairBookingService repairBookingService;
    @MockBean
    RepairCategoryService repairCategoryService;
    @MockBean
    RepairCafeService repairCafeService;
    @MockBean
    EmailService emailService;

    @Test
    public void shouldAddANewRepairBooking() throws Exception {
        //GIVEN
        RepairBookingDTO newRepairBooking = new RepairBookingDTO(1, "Fei", "Liu", "liufei20021002@gmail.com", Date.valueOf("27/11/2022"), "Bicycle", "Bangor");
        SaveRepairBookingRequest saveRepairBookingRequest = SaveRepairBookingRequest.of().repairBookingDTO(newRepairBooking).build();
        SaveRepairBookingResponse saveRepairBookingResponse = SaveRepairBookingResponse
                .of()
                .saveRepairBookingRequest(saveRepairBookingRequest)
                .build();

        given(repairBookingService.addNewRepairBooking(saveRepairBookingRequest)).willReturn(saveRepairBookingResponse);

        //WHEN
        ResultActions result = mvc
                .perform(post("/repair/booking/add")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isCreated());

        //THEN
        result.andExpect(status().is3xxRedirection());
//                .andExpect(redirectedUrl("/repair-booking-list"));
    }
}
