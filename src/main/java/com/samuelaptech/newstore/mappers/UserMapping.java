package com.samuelaptech.newstore.mappers;

import com.samuelaptech.newstore.dto.UserDTO;
import com.samuelaptech.newstore.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapping {
    UserDTO userToUserDTO(User user);

}
