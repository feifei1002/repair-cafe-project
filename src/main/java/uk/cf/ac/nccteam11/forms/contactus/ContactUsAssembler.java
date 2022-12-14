package uk.cf.ac.nccteam11.forms.contactus;

public class ContactUsAssembler {
    static ContactUsDTO toDto(ContactUsForm cu) {
        return new ContactUsDTO(cu.getInstanceId(), cu.getFullName(), cu.getEmail(), cu.getReason(), cu.getMessage());
    }
}
