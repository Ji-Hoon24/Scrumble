package kr.co.scrumble.dto.model;

import kr.co.scrumble.dto.Enum.Role;
import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("userDto")
public class UserDto {

    private Long userNo;

    private String email;

    private String name;

    private Role role;


}
