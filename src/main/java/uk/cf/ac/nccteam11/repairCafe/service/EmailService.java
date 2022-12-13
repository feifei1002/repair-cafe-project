package uk.cf.ac.nccteam11.repairCafe.service;

import uk.cf.ac.nccteam11.repairCafe.web.RepairBookingForm;
import uk.cf.ac.nccteam11.forms.contactus.ContactUsForm;

public interface EmailService {
    String sendSimpleMail(RepairBookingForm details);
    String sendContactForm(ContactUsForm payload);
}
