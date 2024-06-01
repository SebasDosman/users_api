package co.com.dosman.roles.dto;

import co.com.dosman.roles.utilities.RoleValidate;
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
public class CreateRoleDTO {
    @NotNull(message = RoleValidate.NAME_NOT_NULL)
    @NotBlank(message = RoleValidate.NAME_NOT_BLANK)
    @NotEmpty(message = RoleValidate.NAME_NOT_EMPTY)
    @Pattern(message = RoleValidate.NAME_NOT_VALID, regexp = RoleValidate.NAME_REGEX)
    private String name;

    @NotNull(message = RoleValidate.DESCRIPTION_NOT_NULL)
    @NotBlank(message = RoleValidate.DESCRIPTION_NOT_BLANK)
    @NotEmpty(message = RoleValidate.DESCRIPTION_NOT_EMPTY)
    private String description;
}
