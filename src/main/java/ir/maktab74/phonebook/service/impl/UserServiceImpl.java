package ir.maktab74.phonebook.service.impl;

import ir.maktab74.phonebook.base.service.BaseEntityService;
import ir.maktab74.phonebook.base.service.impl.BaseEntityServiceImpl;
import ir.maktab74.phonebook.entity.User;
import ir.maktab74.phonebook.repository.UserRepository;
import ir.maktab74.phonebook.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseEntityServiceImpl<User, Long, UserRepository>
    implements UserService {
    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }


    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User user = repository.getByUsernameAndPassword(username, password);
        return user;
    }
}
