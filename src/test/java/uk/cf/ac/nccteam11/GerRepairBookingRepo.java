package uk.cf.ac.nccteam11;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import uk.cf.ac.nccteam11.repairCafe.repository.RepairBookingRepository;
import uk.cf.ac.nccteam11.repairCafe.service.RepairBookingDTO;
import uk.cf.ac.nccteam11.repairCafe.service.RepairBookingService;
import uk.cf.ac.nccteam11.repairCafe.service.message.RepairBookingListRequest;
import uk.cf.ac.nccteam11.repairCafe.service.message.SaveRepairBookingRequest;

import java.sql.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GerRepairBookingRepo {

    @Autowired
    private RepairBookingService repairBookingService;
    @MockBean
    private RepairBookingRepository repairBookingRepository;

    @Test
    public void shouldGetThreeRepairBookings() throws Exception {
        //GIVEN

        RepairBookingListRequest repairBookingListRequest = RepairBookingListRequest
                .of()
                .build();

        //WHEN
        var repairBookingListResponse = repairBookingService.getRepairBookings(repairBookingListRequest);

        //THEN
        assertEquals(3, repairBookingListResponse.getRepairBookings().size());    }

    @Test
    public void shouldAddANewRepairBooking() throws Exception {
        //GIVEN
        RepairBookingDTO newRepairBooking = new RepairBookingDTO(1, "Fei", "Liu", "liufei20021002@gmail.com", Date.valueOf("27/11/2022"), "Bicycle", "Bangor");
        SaveRepairBookingRequest saveRepairBookingRequest = SaveRepairBookingRequest.of().repairBookingDTO(newRepairBooking).build();
        //WHEN
        var saveRepairBookingResponse = repairBookingService.addNewRepairBooking(saveRepairBookingRequest);
        //THEN
        assertThat(saveRepairBookingResponse).isEqualTo(newRepairBooking);
    }
}