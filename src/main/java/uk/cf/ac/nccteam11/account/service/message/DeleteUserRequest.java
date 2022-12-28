package uk.cf.ac.nccteam11.account.service.message;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(builderMethodName = "of")
public class DeleteUserRequest {
    private Integer userId;
}
