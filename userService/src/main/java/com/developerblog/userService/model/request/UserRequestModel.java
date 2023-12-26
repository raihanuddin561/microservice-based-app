package com.developerblog.userService.model.request;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import static com.developerblog.userService.constants.ValidationMessage.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestModel {
    @NotNull(message = FIRST_NAME_NOT_NULL_MESSAGE)
    @Size(min = 2,message = SIZE_MIN_MESSAGE)
    private String firstName;
    private String lastName;
    @NotNull(message = EMAIL_NOT_NULL_MESSAGE)
    @Size(min = 5,message = SIZE_MIN_MESSAGE)
    private String email;
    private String password;
}
