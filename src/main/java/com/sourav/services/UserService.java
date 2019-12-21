package com.sourav.services;

import java.util.List;

import com.sourav.dtos.UserDTO;
import com.sourav.exceptions.EmailAlreadyUsedException;

public interface UserService {

	UserDTO saveUser(UserDTO userDto) throws EmailAlreadyUsedException;

	UserDTO getUser(Long id);

	List<UserDTO> getAllUsers();

	void deleteUser(Long id);

	UserDTO updateUser(UserDTO userDto);
}
