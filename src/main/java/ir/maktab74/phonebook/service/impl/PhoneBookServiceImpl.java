package ir.maktab74.phonebook.service.impl;

import ir.maktab74.phonebook.base.service.impl.BaseEntityServiceImpl;
import ir.maktab74.phonebook.entity.PhoneBook;
import ir.maktab74.phonebook.entity.User;
import ir.maktab74.phonebook.repository.PhoneBookRepository;
import ir.maktab74.phonebook.repository.UserRepository;
import ir.maktab74.phonebook.service.PhoneBookService;
import ir.maktab74.phonebook.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneBookServiceImpl extends BaseEntityServiceImpl<PhoneBook, Long, PhoneBookRepository>
    implements PhoneBookService {

    public PhoneBookServiceImpl(PhoneBookRepository repository) {
        super(repository);
    }

    @Override
    public List<PhoneBook> findAllPhoneBooksByUser(User user) {
        return repository.findAllByUser(user);
    }
}
