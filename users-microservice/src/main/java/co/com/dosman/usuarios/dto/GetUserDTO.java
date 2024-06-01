package co.com.dosman.usuarios.dto;

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
}
