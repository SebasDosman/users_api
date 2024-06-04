package co.com.dosman.users.dto;

import java.util.List;

import co.com.dosman.common.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;


@AllArgsConstructor
@Builder
@Data
@ToString
public class GetUserDTO {
    private Long id;
    private String name;
    private String lastName;
    private Integer age;
    private String email;
    private String password;
    private Long role_id;
}
