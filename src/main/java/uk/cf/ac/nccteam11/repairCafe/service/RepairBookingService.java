package uk.cf.ac.nccteam11.repairCafe.service;

import uk.cf.ac.nccteam11.repairCafe.service.message.*;

public interface RepairBookingService {
    RepairBookingListResponse getRepairBookings(RepairBookingListRequest repairBookingListRequest);

    SaveRepairBookingResponse addNewRepairBooking(SaveRepairBookingRequest newRepairBookingRequest);
}
