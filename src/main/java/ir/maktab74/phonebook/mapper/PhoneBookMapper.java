package ir.maktab74.phonebook.mapper;

import ir.maktab74.phonebook.base.mapper.BaseMapper;
import ir.maktab74.phonebook.entity.PhoneBook;
import ir.maktab74.phonebook.service.dto.phonebook.PhoneBookBriefDto;
import ir.maktab74.phonebook.service.dto.phonebook.PhoneBookDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PhoneBookMapper extends BaseMapper<PhoneBook, PhoneBookDTO, Long> {

    List<PhoneBookBriefDto> convertEntityListToPhoneBookBriefDto(List<PhoneBook> phoneBookList);

}