package uk.cf.ac.nccteam11.account.service.message;

import lombok.Builder;
import lombok.Value;
import uk.cf.ac.nccteam11.account.service.UserDTO;

@Value
@Builder(builderMethodName = "of")
public class UpdateUserRequest {
    private final Integer userId;
    private final UserDTO userDTO;
}
