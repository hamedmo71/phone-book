package ir.maktab74.phonebook.service;

import ir.maktab74.phonebook.base.service.BaseEntityService;
import ir.maktab74.phonebook.entity.PhoneBook;
import ir.maktab74.phonebook.entity.User;

import java.util.List;

public interface PhoneBookService extends BaseEntityService<PhoneBook, Long> {

    List<PhoneBook> findAllPhoneBooksByUser(User user);

}
