package kr.co.scrumble.config.auth.dto;

import kr.co.scrumble.user.dto.Enum.Role;
import kr.co.scrumble.user.dto.model.UserDto;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.userdetails.User;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name, String email) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
    }

    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
        return ofGoogle(userNameAttributeName, attributes);
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
            .name((String) attributes.get("name"))
            .email((String) attributes.get("email"))
            .attributes(attributes)
            .nameAttributeKey(userNameAttributeName)
            .build();
    }

    public UserDto toEntity() {
        UserDto userDto = new UserDto();
        userDto.setName(name);
        userDto.setEmail(email);
        userDto.setRole(Role.GUEST);
        return userDto;
    }
}
