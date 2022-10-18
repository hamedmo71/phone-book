package ir.maktab74.phonebook.resource;

import ir.maktab74.phonebook.base.resource.BaseResource;
import ir.maktab74.phonebook.entity.PhoneBook;
import ir.maktab74.phonebook.mapper.PhoneBookMapper;
import ir.maktab74.phonebook.service.PhoneBookService;
import ir.maktab74.phonebook.service.dto.phonebook.PhoneBookBriefDto;
import ir.maktab74.phonebook.service.dto.phonebook.PhoneBookDTO;
import ir.maktab74.phonebook.util.SecurityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/phonebook")
public class PhoneBookResource extends BaseResource<PhoneBook, PhoneBookDTO, Long, PhoneBookService, PhoneBookMapper> {
    public PhoneBookResource(PhoneBookService baseService, PhoneBookMapper baseMapper) {
        super(baseService, baseMapper);
    }


    @Autowired
    private PhoneBookMapper phoneBookMapper;

    @Override
    public ResponseEntity<PhoneBookDTO> save(@RequestBody PhoneBookDTO phoneBookDTO) {
        PhoneBook phoneBook = baseMapper.convertDTOToEntity(phoneBookDTO);
        phoneBook.setUser(SecurityContext.getCurrentUser());
        baseService.save(phoneBook);
        return ResponseEntity.ok(baseMapper.convertEntityToDTO(phoneBook));
    }

    @GetMapping("/phonebooks-list")
    public ResponseEntity<List<PhoneBookBriefDto>> getPhoneBookOfSpecifiedUser(){
        List<PhoneBook> phoneBooksByUser =
                baseService.findAllPhoneBooksByUser(SecurityContext.getCurrentUser());

        ResponseEntity<List<PhoneBookBriefDto>> listResponseEntity =
                ResponseEntity.ok(phoneBookMapper.convertEntityListToPhoneBookBriefDto(phoneBooksByUser));
        return listResponseEntity;
    }
}
