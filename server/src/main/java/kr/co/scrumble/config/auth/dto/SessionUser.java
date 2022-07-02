package kr.co.scrumble.config.auth.dto;

import kr.co.scrumble.user.dto.model.UserDto;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;

    public SessionUser(UserDto user) {
        this.name = user.getName();
        this.email = user.getEmail();
    }
}
