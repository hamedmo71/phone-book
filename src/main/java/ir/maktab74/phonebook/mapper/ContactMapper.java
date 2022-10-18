package ir.maktab74.phonebook.mapper;

import ir.maktab74.phonebook.base.mapper.BaseMapper;
import ir.maktab74.phonebook.entity.Contact;
import ir.maktab74.phonebook.service.dto.contact.ContactDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ContactMapper extends BaseMapper<Contact, ContactDTO, Long> {
}
