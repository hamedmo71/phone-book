package ir.maktab74.phonebook.resource;

import ir.maktab74.phonebook.base.exception.GithubRepositoryNotFoundRuntimeException;
import ir.maktab74.phonebook.base.resource.BaseResource;
import ir.maktab74.phonebook.entity.Contact;
import ir.maktab74.phonebook.mapper.ContactMapper;
import ir.maktab74.phonebook.service.ContactService;
import ir.maktab74.phonebook.service.PhoneBookService;
import ir.maktab74.phonebook.service.dto.contact.ContactDTO;
import ir.maktab74.phonebook.service.dto.extra.ContactSearch;
import ir.maktab74.phonebook.util.SecurityContext;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/contact")
public class ContactResource extends BaseResource<Contact, ContactDTO, Long, ContactService, ContactMapper> {
    public ContactResource(ContactService baseService, ContactMapper baseMapper) {
        super(baseService, baseMapper);
    }

    @Autowired
    private PhoneBookService phoneBookService;

    @PostMapping("/save/{phonebook_id}")
    public ResponseEntity<ContactDTO> saveContact(@RequestBody ContactDTO contactDTO,
                                                  @PathVariable("phonebook_id") Long phoneBookId) {
        Contact contact = baseMapper.convertDTOToEntity(contactDTO);
        contact.setPhoneBook(phoneBookService.findById(phoneBookId).get());

        if (contactDTO.getGithubUsername()!=null && !contactDTO.getGithubUsername().isEmpty()){
            RestTemplate restTemplate = new RestTemplate();

            try {
                String githubUrl = "https://api.github.com/users/" + contactDTO.getGithubUsername() + "/repos";
                ResponseEntity<String> githubResponse = restTemplate.getForEntity(githubUrl, String.class);
                JSONArray jsonArray = new JSONArray(githubResponse.getBody());
                List<String> repositoryNameList = IntStream.range(0, jsonArray.length())
                        .mapToObj(
                                index ->
                                        ((JSONObject) jsonArray.get(index))
                                                .getString("name")
                        )
                        .collect(toList());

                Set<String> githubRepos = new HashSet<>();
                for (String repositoryName : repositoryNameList) {
                    githubRepos.add(repositoryName);
                }
                contact.setGithubRepos(githubRepos);
            }catch (HttpClientErrorException ex){
                throw new GithubRepositoryNotFoundRuntimeException("github username is invalid");
            }

        }

        return ResponseEntity.ok(baseMapper.convertEntityToDTO(baseService.save(contact)));
    }


    @PostMapping("/search")
    public ResponseEntity<Page<Contact>> searchContact(@RequestBody ContactSearch contactSearch) {
        return ResponseEntity.ok(baseService.findAllByAdvanceSearch(contactSearch, SecurityContext.getCurrentUser().getId()));

    }
}
