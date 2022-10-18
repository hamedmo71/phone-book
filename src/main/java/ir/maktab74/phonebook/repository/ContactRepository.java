package ir.maktab74.phonebook.repository;

import ir.maktab74.phonebook.base.repository.BaseEntityRepository;
import ir.maktab74.phonebook.entity.Contact;
import ir.maktab74.phonebook.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;

import java.util.List;

public interface ContactRepository extends BaseEntityRepository<Contact, Long> {


    @Override
    @EntityGraph (attributePaths = {"mobileNumbers" , "phoneNumbers" , "organizationalPhoneNumbers" , "faxNumbers" , "emailAddresses"})
    List<Contact> findAll();

    @Override
    @EntityGraph (attributePaths = {"mobileNumbers" , "phoneNumbers" , "organizationalPhoneNumbers" , "faxNumbers" , "emailAddresses", "phoneBook", "phoneBook.user"})
    Page<Contact> findAll(Specification<Contact> contact, Pageable pageable);
}
