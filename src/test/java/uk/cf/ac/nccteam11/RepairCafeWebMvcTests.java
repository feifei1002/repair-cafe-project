package uk.cf.ac.nccteam11;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;
import uk.cf.ac.nccteam11.account.web.WebSecurityConfig;
import uk.cf.ac.nccteam11.repairCafe.service.RepairCafeDTO;
import uk.cf.ac.nccteam11.repairCafe.service.RepairCafeService;
import uk.cf.ac.nccteam11.repairCafe.service.message.SaveRepairCafeRequest;
import uk.cf.ac.nccteam11.repairCafe.service.message.SaveRepairCafeResponse;
import uk.cf.ac.nccteam11.repairCafe.web.RepairCafeController;

import static org.mockito.BDDMockito.given;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = RepairCafeController.class)
public class RepairCafeWebMvcTests {
    @Autowired
    MockMvc mvc;
    @MockBean
    RepairCafeService repairCafeService;
    @MockBean
    WebSecurityConfig webSecurityConfig;

    @Test
    @WithUserDetails
    public void shouldAddANewRepairCafe() throws Exception {
        //GIVEN
        RepairCafeDTO newRepairCafe = new RepairCafeDTO(11, "Newport Repair Cafe", "Information Station, Old Station Building, Queensway", "Newport", "NP20 4AX");

        //WHEN
        SaveRepairCafeRequest saveRepairCafeRequest = SaveRepairCafeRequest.of().repairCafeDTO(newRepairCafe).build();
        SaveRepairCafeResponse saveRepairCafeResponse = SaveRepairCafeResponse.of().saveRepairCafeRequest(saveRepairCafeRequest).build();
        given(repairCafeService.addNewRepairCafe(saveRepairCafeRequest)).willReturn(saveRepairCafeResponse);

        //THEN
        mvc.perform(post("/admin/repair-cafe/add").with(csrf())).andExpect(status().is2xxSuccessful());
    }

}
