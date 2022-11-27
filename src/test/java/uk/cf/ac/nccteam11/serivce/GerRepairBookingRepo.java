package uk.cf.ac.nccteam11.serivce;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uk.cf.ac.nccteam11.repairCafe.service.RepairBookingService;
import uk.cf.ac.nccteam11.repairCafe.service.message.RepairBookingListRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GerRepairBookingRepo {

    @Autowired
    private RepairBookingService repairBookingService;

    @Test
    public void shouldGetThreeRepairBookings() throws Exception {
        //GIVEN

        RepairBookingListRequest repairBookingListRequest = RepairBookingListRequest
                .of()
                .build();

        //WHEN
        var repairBookingListResponse = repairBookingService.getRepairBookings(repairBookingListRequest);

        //THEN
        assertEquals(3, repairBookingListResponse.getRepairBookings().size());

    }
}
