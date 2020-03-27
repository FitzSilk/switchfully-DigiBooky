package com.switchfully.javadocjuveniles.service.users;

import com.switchfully.javadocjuveniles.domain.book.Borrowable;
import com.switchfully.javadocjuveniles.domain.user.Address;
import com.switchfully.javadocjuveniles.domain.user.feature.UserRole;

import java.util.List;

public class MemberDto extends UserDto {

    private final String INSS;
    private final Address address;
    private final List<Borrowable> itemsBorrowed;
    //private final List<Fines> fines;

    public MemberDto(String id, String firstName, String lastName, String email, String password, String INSS, Address address, List<Borrowable> itemsBorrowed) {
        super(id, firstName, lastName, email, password, UserRole.MEMBER);
        this.INSS = INSS;
        this.address = address;
        this.itemsBorrowed = itemsBorrowed;
    }


    public String getFirstName() {
        return super.getFirstName();
    }

    public String getLastName() {
        return super.getLastName();
    }

    public String getEmail() {
        return super.getEmail();
    }

    public String getPassword() {
        return super.getPassWord();
    }

    public Address getAddress() {
        return address;
    }

    public String getINSS() {
        return INSS;
    }
}
