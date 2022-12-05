package uk.cf.ac.nccteam11.account.service.message;

import lombok.Builder;
import lombok.Value;
import uk.cf.ac.nccteam11.account.service.UserDTO;

@Value
@Builder(builderMethodName = "of")
public class SaveUserRequest {
    private final UserDTO userDTO;
}
