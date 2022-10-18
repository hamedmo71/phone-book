package ir.maktab74.phonebook.repository;

import ir.maktab74.phonebook.base.repository.BaseEntityRepository;
import ir.maktab74.phonebook.entity.User;

public interface UserRepository extends BaseEntityRepository<User, Long> {

    User getByUsernameAndPassword(String username, String password);
}
