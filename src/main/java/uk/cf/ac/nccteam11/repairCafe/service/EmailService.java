package uk.cf.ac.nccteam11.repairCafe.service;

import uk.cf.ac.nccteam11.repairCafe.web.RepairBookingForm;

public interface EmailService {
    String sendSimpleMail(RepairBookingForm details);
}
