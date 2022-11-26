package uk.cf.ac.nccteam11.repairCafe.service;

import uk.cf.ac.nccteam11.repairCafe.service.message.RepairBookingListRequest;
import uk.cf.ac.nccteam11.repairCafe.service.message.RepairBookingListResponse;
import uk.cf.ac.nccteam11.repairCafe.service.message.SaveRepairBookingRequest;
import uk.cf.ac.nccteam11.repairCafe.service.message.SaveRepairBookingResponse;

import java.util.List;

public interface RepairBookingService {
    RepairBookingListResponse getRepairBookings(RepairBookingListRequest repairBookingListRequest);

    SaveRepairBookingResponse addNewRepairBooking(SaveRepairBookingRequest repairBookingRequest);
}
