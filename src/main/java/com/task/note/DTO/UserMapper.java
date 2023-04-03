package com.task.note.DTO;

import com.task.note.Entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    User fromDto(UserDto userDto);
}
