package ir.maktab74.phonebook.entity;

import ir.maktab74.phonebook.base.domain.BaseEntity;
import lombok.*;
import net.bytebuddy.matcher.StringSetMatcher;
import org.aspectj.asm.internal.NameConvertor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Contact extends BaseEntity<Long> {

    @Column(nullable = false)
    private String fullName;

    @ElementCollection
    private Set<String> mobileNumbers = new HashSet<>();

    @ElementCollection
    private Set<String> phoneNumbers = new HashSet<>();

    @ElementCollection
    private Set<String> organizationalPhoneNumbers = new HashSet<>();

    @ElementCollection
    private Set<String> faxNumbers = new HashSet<>();

    @ElementCollection
    private Set<String> emailAddresses = new HashSet<>();

    @Column(unique = true)
    private String githubUsername;

    @ElementCollection
    private Set<String> githubRepos;

    @Column(unique = true)
    private String linkedinUsername;

    @ManyToOne
    private PhoneBook phoneBook;


}
