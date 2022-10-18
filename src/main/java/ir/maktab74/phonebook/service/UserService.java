package ir.maktab74.phonebook.service;

import ir.maktab74.phonebook.base.service.BaseEntityService;
import ir.maktab74.phonebook.entity.User;

public interface UserService extends BaseEntityService<User, Long> {
    User findByUsernameAndPassword(String username, String password);


}
