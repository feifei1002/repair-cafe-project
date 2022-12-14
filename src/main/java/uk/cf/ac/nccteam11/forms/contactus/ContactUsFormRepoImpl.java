package uk.cf.ac.nccteam11.forms.contactus;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Repository
public class ContactUsFormRepoImpl implements ContactUsRepo{

    private final ContactUsRepoJdbc contactUsRepoJdbc;

    public ContactUsFormRepoImpl(ContactUsRepoJdbc contactUsRepoJdbc) {
        this.contactUsRepoJdbc = contactUsRepoJdbc;
    }

    public List<ContactUsForm> getContactUsForm() {
        List<ContactUsForm> contactUsForms = new ArrayList<>();
        contactUsRepoJdbc.findAll().forEach((Consumer<? super ContactUsForm>) contactUsForms);
        return contactUsForms;
    }

}
