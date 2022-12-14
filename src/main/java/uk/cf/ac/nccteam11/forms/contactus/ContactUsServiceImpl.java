package uk.cf.ac.nccteam11.forms.contactus;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactUsServiceImpl implements ContactUsService{

    private final ContactUsRepo contactUsRepo;

    public ContactUsServiceImpl(ContactUsRepo contactUsRepo) {
        this.contactUsRepo = contactUsRepo;
    }


    public ContactUsResponse getContactUsForm(ContactUsRequest contactUsRequest) {
        List<ContactUsDTO> contactUsList = getContactUsForm();
        return ContactUsResponse.of()
                .contactUsRequest(contactUsRequest)
                .build();
    }

    private List<ContactUsDTO> getContactUsForm() {

        List<ContactUsForm> contactUsForms = contactUsRepo.getContactUsForm();

        return contactUsForms.stream().map(cu -> ContactUsAssembler.toDto(cu)).collect(Collectors.toList());
    }
}
