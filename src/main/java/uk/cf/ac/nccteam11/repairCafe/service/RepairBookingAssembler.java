package uk.cf.ac.nccteam11.repairCafe.service;

import uk.cf.ac.nccteam11.repairCafe.domain.RepairBooking;

public class RepairBookingAssembler {
    static RepairBookingDTO toDTO(RepairBooking rb) {
        return new RepairBookingDTO(rb.getBooking_id(), rb.getFirstName(), rb.getLastName(), rb.getEmail(), rb.getRepairDate(), rb.getLocation());
    }
}
