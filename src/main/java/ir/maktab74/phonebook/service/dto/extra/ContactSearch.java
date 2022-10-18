package ir.maktab74.phonebook.service.dto.extra;

import ir.maktab74.phonebook.base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactSearch {

    private String firstName;
    private String mobileNumbers;
    private String phoneNumbers;
    private String OrganizationalPhoneNumbers;
    private String faxNumbers;
    private String emailAddresses;
    private String githubUsername;
    private String linkedinUsername;


}
