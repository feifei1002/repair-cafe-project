package uk.cf.ac.nccteam11;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uk.cf.ac.nccteam11.repairCafe.service.RepairBookingService;
import uk.cf.ac.nccteam11.repairCafe.service.RepairCafeService;
import uk.cf.ac.nccteam11.repairCafe.service.RepairCategoryService;
import uk.cf.ac.nccteam11.repairCafe.service.message.RepairBookingListRequest;
import uk.cf.ac.nccteam11.repairCafe.service.message.RepairCafeListRequest;
import uk.cf.ac.nccteam11.repairCafe.service.message.RepairCategoryListRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RepairBookingServiceTest {

    @Autowired
    private RepairBookingService repairBookingService;
    @Autowired
    private RepairCafeService repairCafeService;
    @Autowired
    private RepairCategoryService repairCategoryService;

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
    public void ShouldGet10RepairCafes() throws Exception{
        //GIVEN

        RepairCafeListRequest repairCafeListRequest = RepairCafeListRequest
                .of()
                .build();

        //WHEN
        var repairCafeListResponse = repairCafeService.getRepairCafes(repairCafeListRequest);

        //THEN
        assertEquals(10, repairCafeListResponse.getRepairCafes().size());
    }

    @Test
    public void ShouldGetAllCategories() throws Exception{
        RepairCategoryListRequest repairCategoryListRequest = RepairCategoryListRequest
                .of()
                .build();

        //WHEN
        var repairCategoryListResponse = repairCategoryService.getRepairCategories(repairCategoryListRequest);

        //THEN
        assertEquals(13, repairCategoryListResponse.getRepairCategories().size());
    }
}