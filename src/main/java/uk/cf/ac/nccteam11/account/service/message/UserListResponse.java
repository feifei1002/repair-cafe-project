package uk.cf.ac.nccteam11.account.service.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import uk.cf.ac.nccteam11.account.service.UserDTO;

import java.util.List;

@Value
@AllArgsConstructor
@Builder(builderMethodName = "of")
public class UserListResponse {
    private UserListRequest request;
    private List<UserDTO> users;
}
