package com.switchfully.javadocjuveniles.service.users;

import com.switchfully.javadocjuveniles.domain.user.Member;
import com.switchfully.javadocjuveniles.domain.user.User;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

import static com.switchfully.javadocjuveniles.domain.user.builders.UserBuilder.userBuilder;

@Component
public class UserMapper {

    public UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getRole());
    }

    public User toUser(CreateUserDto createUserDto) {
        return userBuilder()
                .withFirstName(createUserDto.getFirstName())
                .withLastName(createUserDto.getLastName())
                .withEmail(createUserDto.getEmail())
                .withPassWord(createUserDto.getPassword())
                .buildMember();
    }
}