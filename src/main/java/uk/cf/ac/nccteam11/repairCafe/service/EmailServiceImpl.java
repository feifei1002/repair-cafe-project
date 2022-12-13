package uk.cf.ac.nccteam11.repairCafe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import uk.cf.ac.nccteam11.forms.contactus.ContactUsForm;
import uk.cf.ac.nccteam11.repairCafe.web.RepairBookingForm;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public String sendSimpleMail(RepairBookingForm details) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("liufei520.02@gmail.com");
            mailMessage.setTo(details.getEmail());
            mailMessage.setText("Your product is successfully booked for repair!");
            mailMessage.setSubject("Booking Successful");
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }
        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }

    public String sendContactForm(ContactUsForm payload) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("louispolly78@yahoo.com");
            mailMessage.setTo(payload.getEmail());
            mailMessage.setText("Hello, thank you for contacting us, an admin has been contacted and will review your enquiry shortly.");
            mailMessage.setSubject(payload.getFullName() + "'s enquiry");
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }
        catch (Exception e) {
            return "Error while Sending mail";
        }
    }
}
