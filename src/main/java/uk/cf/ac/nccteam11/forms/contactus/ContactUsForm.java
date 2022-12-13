package uk.cf.ac.nccteam11.forms.contactus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class ContactUsForm {

    private Integer instanceId;

    @NotEmpty
    private String fullName;

    @NotEmpty
    @Pattern(regexp=".+@.+\\.[a-z]+", message = "Invalid characters")
    private String email;

    @NotEmpty
    private String reason;

    private String message;
}
