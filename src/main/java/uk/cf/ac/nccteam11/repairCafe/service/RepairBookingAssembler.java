package uk.cf.ac.nccteam11.repairCafe.service;

import uk.cf.ac.nccteam11.repairCafe.domain.RepairBooking;

public class RepairBookingAssembler {
    static RepairBookingDTO toDTO(RepairBooking rb) {
        return new RepairBookingDTO(rb.getBookingId(), rb.getFirstName(), rb.getLastName(), rb.getEmail(), rb.getRepairDate(), rb.getCategory(), rb.getLocation());
    }
}
