package ir.maktab74.phonebook.repository;

import ir.maktab74.phonebook.base.repository.BaseEntityRepository;
import ir.maktab74.phonebook.entity.PhoneBook;
import ir.maktab74.phonebook.entity.User;

import java.util.List;

public interface PhoneBookRepository extends BaseEntityRepository<PhoneBook, Long> {


    List<PhoneBook> findAllByUser(User user);
}
