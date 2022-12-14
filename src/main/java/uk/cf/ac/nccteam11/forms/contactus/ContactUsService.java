package uk.cf.ac.nccteam11.forms.contactus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface ContactUsService {

    ContactUsResponse getContactUsForm(ContactUsRequest contactUsRequest);

}
