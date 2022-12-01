package uk.cf.ac.nccteam11.repairCafe.repository;

import org.springframework.stereotype.Repository;
import uk.cf.ac.nccteam11.repairCafe.domain.RepairBooking;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepairBookingRepositoryImpl implements RepairBookingRepository{
    private final RepairBookingRepositoryJdbc repairBookingRepoJdbc;

    public RepairBookingRepositoryImpl(RepairBookingRepositoryJdbc rbRepoJdbc) {
        this.repairBookingRepoJdbc = rbRepoJdbc;

    }
    public List<RepairBooking> getRepairBookings() {
        List<RepairBooking> repairBookings = new ArrayList<>();
        repairBookingRepoJdbc.findAll().forEach(repairBookings::add);
        return repairBookings;
    }

    @Override
    public void addRepairBooking(RepairBooking repairBooking) {
        repairBookingRepoJdbc.save(repairBooking);
    }
}
