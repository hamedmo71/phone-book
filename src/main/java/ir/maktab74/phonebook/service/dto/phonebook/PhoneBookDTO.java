package ir.maktab74.phonebook.service.dto.phonebook;

import ir.maktab74.phonebook.base.service.dto.BaseDTO;
import ir.maktab74.phonebook.service.dto.contact.ContactDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneBookDTO extends BaseDTO<Long> {

    private String name;

    private Set<ContactDTO> contacts = new HashSet<>();
}
