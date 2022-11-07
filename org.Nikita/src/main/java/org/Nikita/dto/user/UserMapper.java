package org.Nikita.dto.user;

import org.Nikita.entities.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    List<SimpleUserDto> convertUsersToSimpleUsers(List<User> users);
    SimpleUserDto convertUserToSimpleUser(User user);
}
