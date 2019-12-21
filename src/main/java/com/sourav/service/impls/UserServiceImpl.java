package com.sourav.service.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourav.domains.User;
import com.sourav.dtos.UserDTO;
import com.sourav.exceptions.EmailAlreadyUsedException;
import com.sourav.exceptions.UserNotFoundException;
import com.sourav.mapper.UserMapper;
import com.sourav.repositories.UserRepository;
import com.sourav.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDTO saveUser(UserDTO userDTO) throws EmailAlreadyUsedException {
		if (userRepository.findByEmail(userDTO.getEmail()).isEmpty()) {
			throw new EmailAlreadyUsedException();
		}
		User user = userRepository.save(UserMapper.userDtoToUser(userDTO));
		return UserMapper.userToUserDto(user);
	}

	@Override
	public UserDTO getUser(Long id) throws UserNotFoundException {
		User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
		return UserMapper.userToUserDto(user);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		return UserMapper.usersToUserDtos((userRepository.findAll()));
	}

	@Override
	public void deleteUser(Long id) throws UserNotFoundException {
		if (userRepository.findById(id).isEmpty())
			throw new UserNotFoundException();
		userRepository.deleteById(id);
	}

	@Override
	public UserDTO updateUser(UserDTO userDto) throws UserNotFoundException {
		User user = userRepository.findById(userDto.getId()).orElseThrow(() -> new UserNotFoundException());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		return UserMapper.userToUserDto(userRepository.save(user));
	}

}
