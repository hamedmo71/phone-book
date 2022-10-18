package ir.maktab74.phonebook.mapper;

import ir.maktab74.phonebook.base.mapper.BaseMapper;
import ir.maktab74.phonebook.entity.User;
import ir.maktab74.phonebook.service.dto.user.UserBriefDto;
import ir.maktab74.phonebook.service.dto.user.UserDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User, UserDTO, Long> {

    UserBriefDto convertUserToUserBriefDto(User user);
}