package uk.cf.ac.nccteam11.forms.contactus;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class ContactUsDTO {
    private Integer instanceId;
    private String fullName;
    private String email;
    private String reason;
    private String message;
}
