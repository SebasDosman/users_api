package co.com.dosman.users.dto;

import co.com.dosman.users.utilities.UserValidate;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;


@AllArgsConstructor
@Builder
@Data
@ToString
public class CreateUserDTO {
    @NotNull(message = UserValidate.NAME_NOT_NULL)
    @NotBlank(message = UserValidate.NAME_NOT_BLANK)
    @NotEmpty(message = UserValidate.NAME_NOT_EMPTY)
    @Pattern(regexp = UserValidate.NAME_REGEX, message = UserValidate.NAME_NOT_VALID)
    private String name;

    @NotNull(message = UserValidate.LAST_NAME_NOT_NULL)
    @NotBlank(message = UserValidate.LAST_NAME_NOT_BLANK)
    @NotEmpty(message = UserValidate.LAST_NAME_NOT_EMPTY)
    @Pattern(regexp = UserValidate.LAST_NAME_REGEX, message = UserValidate.LAST_NAME_NOT_VALID)
    private String lastName;

    @NotNull(message = UserValidate.AGE_NOT_NULL)
    @Min(value = 1, message = UserValidate.AGE_TOO_YOUNG)
    @Max(value = 100, message = UserValidate.AGE_TOO_OLD)
    private Integer age;

    @NotNull(message = UserValidate.EMAIL_NOT_NULL)
    @NotBlank(message = UserValidate.EMAIL_NOT_BLANK)
    @NotEmpty(message = UserValidate.EMAIL_NOT_EMPTY)
    @Pattern(regexp = UserValidate.EMAIL_REGEX, message = UserValidate.EMAIL_NOT_VALID)
    private String email;

    @NotNull(message = UserValidate.PASSWORD_NOT_NULL)
    @NotBlank(message = UserValidate.PASSWORD_NOT_BLANK)
    @NotEmpty(message = UserValidate.PASSWORD_NOT_EMPTY)
    @Pattern(regexp = UserValidate.PASSWORD_REGEX, message = UserValidate.PASSWORD_NOT_VALID)
    private String password;
}
