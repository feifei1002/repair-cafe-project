package uk.cf.ac.nccteam11.forms.contactus;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(builderMethodName = "of")
public class ContactUsRequest {
    private final ContactUsDTO contactUsDTO;
}
