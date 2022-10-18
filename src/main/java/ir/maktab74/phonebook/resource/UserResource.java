package ir.maktab74.phonebook.resource;

import ir.maktab74.phonebook.base.resource.BaseResource;
import ir.maktab74.phonebook.entity.User;
import ir.maktab74.phonebook.mapper.UserMapper;
import ir.maktab74.phonebook.service.UserService;
import ir.maktab74.phonebook.service.dto.user.UserBriefDto;
import ir.maktab74.phonebook.service.dto.user.UserDTO;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserResource extends BaseResource<User, UserDTO, Long, UserService, UserMapper> {
    public UserResource(UserService baseService, UserMapper baseMapper) {
        super(baseService, baseMapper);
    }

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/save")
    public ResponseEntity<UserBriefDto> saveUser(@RequestBody UserDTO userDTO) {
        User user = baseMapper.convertDTOToEntity(userDTO);
        User savedUser = baseService.save(user);
        HttpStatus httpStatus=HttpStatus.CREATED;
        return new ResponseEntity(userMapper.convertUserToUserBriefDto(savedUser),httpStatus);
    }
}
