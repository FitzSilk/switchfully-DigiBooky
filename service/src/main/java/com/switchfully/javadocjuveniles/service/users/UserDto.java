package com.switchfully.javadocjuveniles.service.users;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.switchfully.javadocjuveniles.domain.user.feature.UserRole;

public class UserDto {
    private String id;
    private String firstName;
    private String lastName;
    private String email; //TODO implement format validation in the controller & unique
    private UserRole role;
    private String passWord;

    @JsonCreator
    public UserDto(String firstName, String lastName, String email, String password, UserRole userRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = userRole;
        this.passWord = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public UserRole getRole() {
        return role;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setId(String id) {
        this.id = id;
    }
}
