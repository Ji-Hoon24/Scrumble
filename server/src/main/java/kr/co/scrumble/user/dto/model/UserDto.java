package kr.co.scrumble.user.dto.model;

import kr.co.scrumble.user.dto.Enum.Role;
import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("userDto")
public class UserDto {

    private Long userNo;

    private String email;

    private String name;

    private Role role;

    public String getRoleKey() {
        return this.role.getKey();
    }

    public UserDto update(String name) {
        this.name = name;
        return this;
    }
}
