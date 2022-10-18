package ir.maktab74.phonebook;

import com.github.javafaker.Faker;
import ir.maktab74.phonebook.entity.Contact;
import ir.maktab74.phonebook.entity.PhoneBook;
import ir.maktab74.phonebook.entity.User;
import ir.maktab74.phonebook.service.ContactService;
import ir.maktab74.phonebook.service.PhoneBookService;
import ir.maktab74.phonebook.service.UserService;
import ir.maktab74.phonebook.service.dto.extra.ContactSearch;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
@PropertySource(value = "classpath:cookie.properties")
public class PhoneBookApplication {

    public static void main(String[] args) {
SpringApplication.run(PhoneBookApplication.class, args);
//        ContactService contactService = context.getBean(ContactService.class);
///*        List<Contact> contactServiceAll = contactService.findAll();
//        for (Contact c:contactServiceAll) {
//            System.out.println(c);
//        }*/
//        Page<Contact> allByAdvanceSearch = contactService.findAllByAdvanceSearch(
//                new ContactSearch(null, "2", null, null, null, null, "h")
//        );
//        allByAdvanceSearch.forEach(contact -> System.out.println(contact));
    }



//    @GetMapping("/{username}")
//    public String getGithubRepositories(@PathVariable("username") String username) {
//        RestTemplate restTemplate = new RestTemplate();
//        String githubUrl = "https://api.github.com/users/" + username + "/repos";
//        ResponseEntity githubResponse = restTemplate.getForEntity(githubUrl, String.class);
//        JSONArray jsonArray = new JSONArray(githubResponse.getBody());
//        List repositoryNameList = IntStream.range(0, jsonArray.length())
//                .mapToObj(
//                        index ->
//                                ((JSONObject) jsonArray.get(index))
//                                        .getString("name")
//                )
//                .collect(toList());
//        for (String repositoryName : repositoryNameList) {
//            System.out.println(repositoryName);
//        }
//        return "success";
//    }




}
