package com.switchfully.javadocjuveniles.domain.user;

import com.switchfully.javadocjuveniles.domain.exceptions.EmailAlreadyRegisteredException;
import com.switchfully.javadocjuveniles.domain.exceptions.InssAlreadyRegisteredException;
import com.switchfully.javadocjuveniles.domain.exceptions.MemberNotFoundException;
import com.switchfully.javadocjuveniles.domain.fines.DamageFine;
import com.switchfully.javadocjuveniles.domain.fines.OverdueFine;
import com.switchfully.javadocjuveniles.domain.user.builders.UserBuilder;
import com.switchfully.javadocjuveniles.domain.user.feature.UserRole;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

import static com.switchfully.javadocjuveniles.domain.user.builders.AddressBuilder.addressBuilder;

@Repository
public class MemberRepository {
    private final ConcurrentHashMap<String, Member> memberRepository;

    public MemberRepository() {
        this.memberRepository = new ConcurrentHashMap<>();
        createDefaultData();
    }

    public Collection<Member> getAllMembers() {
        return memberRepository.values();
    }

    public Member getMemberByEmail(String email) {
        return memberRepository.values().stream()
                .filter(member -> (member.getEmail().equals(email)))
                .findFirst()
                .orElseThrow(MemberNotFoundException::new);
    }

    public boolean isEmailAvailable(String email) {
        if (memberRepository.values().stream()
                .anyMatch(member -> member.getEmail().equals(email))) {
            throw new EmailAlreadyRegisteredException(email);
        }
        return true;
    }

    public boolean isInssAvailable(String inss) {
        if (memberRepository.values().stream()
        .anyMatch(member -> member.getINSS().equals(inss))) {
            throw new InssAlreadyRegisteredException(inss);
        }
        return true;
    }


    private void createDefaultData() {
        Address address = addressBuilder()
                .withCity("Brussels")
                .withPostalCode("1000")
                .withStreet("Piglane")
                .withStreetNumber("42")
                .build();
        Member member1 = UserBuilder.userBuilder()
                .withINSS("10.10.10-101.10")
                .withEmail("dummy@mail.com")
                .withFirstName("Dummy")
                .withLastName("Member")
                .withPassWord("0000")
                .setAddress(address)
                .withRole(UserRole.MEMBER)
                .buildMember();
        Member member2 = UserBuilder.userBuilder()
                .withINSS("10.10.10-101.10")
                .withEmail("john.doe@dead.com")
                .withFirstName("John")
                .withLastName("Doe")
                .withPassWord("DEAD")
                .setAddress(address)
                .withRole(UserRole.MEMBER)
                .buildMember();
        registerNewMember(member1);
        registerNewMember(member2);
        member1.addFine(new OverdueFine());
        member2.addFine(new DamageFine());
    }

    public Member registerNewMember(Member newMember) {
        memberRepository.put(newMember.getId(), newMember);
        return newMember;
    }

    public Member getMemberById(String id) {
        return memberRepository.get(id);
    }
}
