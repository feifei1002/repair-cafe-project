package uk.cf.ac.nccteam11.repairCafe.service;

import uk.cf.ac.nccteam11.repairCafe.domain.RepairBooking;

import java.util.List;
import java.util.stream.Collectors;

public class RepairBookingAssembler {
    static List<RepairBookingDTO> toDTO(List<RepairBooking> repairBookings) {
        return repairBookings
                .stream()
                .map(c -> new RepairBookingDTO(c.getBooking_id(), c.getFirstName(), c.getLastName(), c.getEmail(), c.getRepairDate(), c.getLocation()))
                .collect(Collectors.toList());
    }
}
