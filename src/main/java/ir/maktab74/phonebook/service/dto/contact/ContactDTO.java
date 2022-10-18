package ir.maktab74.phonebook.service.dto.contact;

import ir.maktab74.phonebook.base.service.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDTO extends BaseDTO<Long> {

    private String fullName;

    private Set<String> mobileNumbers = new HashSet<>();

    private Set<String> phoneNumbers = new HashSet<>();

    private Set<String> organizationalPhoneNumbers = new HashSet<>();

    private Set<String> faxNumbers = new HashSet<>();

    private Set<String> emailAddresses = new HashSet<>();

    private String githubUsername;

    private String linkedinUsername;


}
