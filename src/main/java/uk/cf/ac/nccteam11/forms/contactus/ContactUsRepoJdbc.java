package uk.cf.ac.nccteam11.forms.contactus;

import org.springframework.data.repository.CrudRepository;
import uk.cf.ac.nccteam11.forms.contactus.ContactUsForm;

public interface ContactUsRepoJdbc extends CrudRepository<ContactUsForm, Integer> {

}
