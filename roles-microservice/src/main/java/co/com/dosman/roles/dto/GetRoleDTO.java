package co.com.dosman.roles.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;


@AllArgsConstructor
@Builder
@Data
@ToString
public class GetRoleDTO {
    private Long id;
    private String name;
    private String description;
}
