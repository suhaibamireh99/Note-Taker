package com.task.note.DTO;

import com.task.note.Entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-03T20:23:38+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setSurName( user.getSurName() );
        userDto.setPassword( user.getPassword() );

        return userDto;
    }

    @Override
    public User fromDto(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDto.getId() );
        user.setSurName( userDto.getSurName() );
        user.setPassword( userDto.getPassword() );

        return user;
    }
}
