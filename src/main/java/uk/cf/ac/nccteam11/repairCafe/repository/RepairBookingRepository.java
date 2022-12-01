package uk.cf.ac.nccteam11.repairCafe.repository;
import uk.cf.ac.nccteam11.repairCafe.domain.RepairBooking;

import java.util.List;

public interface RepairBookingRepository {
    List<RepairBooking> getRepairBookings();

    void addRepairBooking(RepairBooking newRepairBooking);
}
