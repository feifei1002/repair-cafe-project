package uk.cf.ac.nccteam11.forms.contactus;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import uk.cf.ac.nccteam11.repairCafe.service.EmailService;

import javax.validation.Valid;

public class ContactUsController {

    private EmailService emailService;

    public ContactUsController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("contactus")
    public ModelAndView contactuspage(@Valid ContactUsForm newContactUsForm, Model model){
        ContactUsDTO contactUsDTO = new ContactUsDTO(newContactUsForm.getInstanceId(), newContactUsForm.getFullName(), newContactUsForm.getEmail(), newContactUsForm.getReason(), newContactUsForm.getMessage());
        emailService.sendContactForm(newContactUsForm);
        return new ModelAndView("contactus");
    }
}
