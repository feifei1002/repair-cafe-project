package uk.cf.ac.nccteam11.repairCafe.service;

import java.util.List;

public interface RepairBookingService {
    List<RepairBookingDTO> getRepairBookings();

    void addNewRepairBooking(RepairBookingDTO repairBookingDTO);
}
