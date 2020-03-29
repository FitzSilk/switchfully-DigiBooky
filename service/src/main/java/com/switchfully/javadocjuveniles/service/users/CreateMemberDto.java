package com.switchfully.javadocjuveniles.service.users;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.switchfully.javadocjuveniles.domain.user.Address;
import com.switchfully.javadocjuveniles.domain.user.feature.UserRole;
import com.switchfully.javadocjuveniles.domain.user.interfaces.ExtraInformation;

public class CreateMemberDto extends CreateUserDto implements ExtraInformation {
    private final String INSS;
    private final Address address;
    //private final List<Borrowable> itemsBorrowed;
    //private final List<Fines> fines;

    @JsonCreator
    public CreateMemberDto(@JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName, @JsonProperty("email") String email, @JsonProperty("password") String password, @JsonProperty("INSS") String INSS, @JsonProperty("address") Address address) {
        super(firstName, lastName, email, password, UserRole.MEMBER);
        this.INSS = INSS;
        this.address = address;
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public Address getAddress() {
        return address;
    }

    @Override
    public String getINSS() {
        return INSS;
    }


}
