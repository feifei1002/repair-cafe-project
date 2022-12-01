package uk.cf.ac.nccteam11.repairCafe.repository;

import org.springframework.data.repository.CrudRepository;
import uk.cf.ac.nccteam11.repairCafe.domain.RepairBooking;

public interface RepairBookingRepositoryJdbc extends CrudRepository<RepairBooking, Integer> {
}
