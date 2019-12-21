package com.sourav.mapper;

import java.util.ArrayList;
import java.util.List;

import com.sourav.domains.User;
import com.sourav.dtos.UserDTO;

public class UserMapper {
	
	//UserDTO to User mapping
	public static User userDtoToUser(UserDTO userDTO) {
		User user = new User();
		//user.setId(userDTO.getId());
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		return user;
	}
	
	//User to UserDTO mapping
	public static UserDTO userToUserDto(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setFirstName(user.getFirstName());
		userDTO.setLastName(user.getLastName());
		userDTO.setEmail(user.getEmail());
		userDTO.setPassword(user.getPassword());
		return userDTO;
	}
	
	// Convert list of Users to list of UserDtos
	public static List<UserDTO> usersToUserDtos(List<User> users){
		List<UserDTO> listUserDto = new ArrayList<UserDTO>();
		users.forEach(user -> {
			UserDTO userDto = new UserDTO();
			userDto.setId(user.getId());
			userDto.setFirstName(user.getFirstName());
			userDto.setLastName(user.getLastName());
			userDto.setEmail(user.getEmail());
			userDto.setPassword(user.getPassword());
			listUserDto.add(userDto);
		});
		return listUserDto;
	}
	
	
}
