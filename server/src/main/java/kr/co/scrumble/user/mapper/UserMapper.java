package kr.co.scrumble.user.mapper;

import kr.co.scrumble.user.dto.model.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface UserMapper {

    UserDto selectUser(Long id);

    Long insertUser(UserDto userDto);

    int updateUser(UserDto userDto);

    int deleteUser(Long id);

    UserDto findByEmail(String email);

}
