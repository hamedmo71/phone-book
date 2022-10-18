package ir.maktab74.phonebook.service.dto.user;

import ir.maktab74.phonebook.base.service.dto.BaseDTO;
import ir.maktab74.phonebook.service.dto.phonebook.PhoneBookDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends BaseDTO<Long> {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private List<PhoneBookDTO> phoneBooks = new ArrayList<>();
}
