package com.switchfully.javadocjuveniles.domain.user;

import com.switchfully.javadocjuveniles.domain.book.Borrowable;
import com.switchfully.javadocjuveniles.domain.user.builders.UserBuilder;

import java.util.ArrayList;
import java.util.List;

public class Member extends User {

    private final String inss;
    private final Address address;
    private final List<Borrowable> itemsBorrowed;
    //private final List<Fines> fines;

    public Member(UserBuilder userBuilder) {
        super(userBuilder);
        this.inss = userBuilder.getInss();
        this.address = userBuilder.getAddress();
        itemsBorrowed = new ArrayList<>();
    }

    public String getInss() {
        return inss;
    }


}