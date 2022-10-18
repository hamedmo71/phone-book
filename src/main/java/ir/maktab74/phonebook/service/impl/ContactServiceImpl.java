package ir.maktab74.phonebook.service.impl;

import antlr.StringUtils;
import ir.maktab74.phonebook.base.service.impl.BaseEntityServiceImpl;
import ir.maktab74.phonebook.entity.Contact;
import ir.maktab74.phonebook.repository.ContactRepository;
import ir.maktab74.phonebook.service.ContactService;
import ir.maktab74.phonebook.service.dto.extra.ContactSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


@Service
public class ContactServiceImpl extends BaseEntityServiceImpl<Contact, Long, ContactRepository>
        implements ContactService {

    public ContactServiceImpl(ContactRepository repository) {
        super(repository);
    }



    @Override
    @EntityGraph(attributePaths = {"mobileNumbers" , "phoneNumbers" , "organizationalPhoneNumbers" , "faxNumbers" , "emailAddresses"})
    public Page<Contact> findAllByAdvanceSearch(ContactSearch contactSearch, Long id) {
        Pageable pageable= PageRequest.ofSize(20);
        return repository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            setFirstName(predicates, root, criteriaBuilder, contactSearch.getFirstName());
            setMobileNumbers(predicates, root, criteriaBuilder, contactSearch.getMobileNumbers());
            setPhoneNumbers(predicates, root, criteriaBuilder, contactSearch.getPhoneNumbers());
            setEmailAddresses(predicates, root, criteriaBuilder, contactSearch.getEmailAddresses());
            setOrganizationalPhoneNumbers(predicates, root, criteriaBuilder, contactSearch.getOrganizationalPhoneNumbers());
            setFaxNumbers(predicates, root, criteriaBuilder, contactSearch.getFaxNumbers());
            setGithubUsername(predicates, root, criteriaBuilder, contactSearch.getGithubUsername());
            setLinkedinUsername(predicates, root, criteriaBuilder, contactSearch.getLinkedinUsername());
            setUserId(predicates, root, criteriaBuilder, id);
            return criteriaBuilder.and(
                    predicates.toArray(new Predicate[0])
            );
        },pageable);
    }

    private void setUserId(List<Predicate> predicates, Root<Contact> root,
                           CriteriaBuilder criteriaBuilder, Long id) {
        predicates.add(
                criteriaBuilder.equal(
                        root.get("phoneBook").get("user").get("id"),id
                )
        );
    }

    private void setFirstName(List<Predicate> predicates, Root<Contact> root,
                              CriteriaBuilder criteriaBuilder, String firstName) {
        if (firstName != null && !firstName.isEmpty()) {
            predicates.add(
                    criteriaBuilder.like(
                            root.get("mobileNumbers"),
                            "%" + firstName + "%"
                    )
            );
        }
    }

    private void setMobileNumbers(List<Predicate> predicates, Root<Contact> root,
                                  CriteriaBuilder criteriaBuilder, String mobileNumbers) {

        if (mobileNumbers != null && !mobileNumbers.isEmpty()) {
            predicates.add(
                    criteriaBuilder.like(
                            root.join("mobileNumbers"),
                            "%" + mobileNumbers + "%"
                    )
            );
        }

    }

    private void setPhoneNumbers(List<Predicate> predicates, Root<Contact> root, CriteriaBuilder criteriaBuilder, String phoneNumbers) {

        if (phoneNumbers != null && !phoneNumbers.isEmpty()) {
            predicates.add(
                    criteriaBuilder.like(
                            root.join("phoneNumbers"),
                            "%" + phoneNumbers + "%"
                    )
            );
        }

    }

    private void setEmailAddresses(List<Predicate> predicates, Root<Contact> root, CriteriaBuilder criteriaBuilder, String emailAddresses) {

        if (emailAddresses != null && !emailAddresses.isEmpty()) {
            predicates.add(
                    criteriaBuilder.like(
                            root.join("emailAddresses"),
                            "%" + emailAddresses + "%"
                    )
            );
        }

    }

    private void setOrganizationalPhoneNumbers(List<Predicate> predicates, Root<Contact> root, CriteriaBuilder criteriaBuilder, String organizationalPhoneNumbers) {

        if (organizationalPhoneNumbers != null && !organizationalPhoneNumbers.isEmpty()) {
            predicates.add(
                    criteriaBuilder.like(
                            root.join("organizationalPhoneNumbers"),
                            "%" + organizationalPhoneNumbers + "%"
                    )
            );
        }

    }

    private void setFaxNumbers(List<Predicate> predicates, Root<Contact> root, CriteriaBuilder criteriaBuilder, String faxNumbers) {

        if (faxNumbers != null && !faxNumbers.isEmpty()) {
            predicates.add(
                    criteriaBuilder.like(
                            root.join("faxNumbers"),
                            "%" + faxNumbers + "%"
                    )
            );
        }

    }

    private void setGithubUsername(List<Predicate> predicates, Root<Contact> root, CriteriaBuilder criteriaBuilder, String githubUsername) {

        if (githubUsername != null && !githubUsername.isEmpty()) {
            predicates.add(
                    criteriaBuilder.like(
                            root.get("githubUsername"),
                            "%" + githubUsername + "%"
                    )
            );
        }

    }

    private void setLinkedinUsername(List<Predicate> predicates, Root<Contact> root, CriteriaBuilder criteriaBuilder, String linkedinUsername) {

        if (linkedinUsername != null && !linkedinUsername.isEmpty()) {
            predicates.add(
                    criteriaBuilder.like(
                            root.get("linkedinUsername"),
                            "%" + linkedinUsername + "%"
                    )
            );
        }

    }


}
