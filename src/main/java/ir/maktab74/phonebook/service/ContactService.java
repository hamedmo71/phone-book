package ir.maktab74.phonebook.service;

import ir.maktab74.phonebook.base.service.BaseEntityService;
import ir.maktab74.phonebook.entity.Contact;
import ir.maktab74.phonebook.entity.User;
import ir.maktab74.phonebook.service.dto.extra.ContactSearch;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ContactService extends BaseEntityService<Contact, Long> {

    Page<Contact> findAllByAdvanceSearch(ContactSearch contactSearch, Long id);


}
