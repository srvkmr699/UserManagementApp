package com.sourav.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sourav.dtos.UserDTO;
import com.sourav.exceptions.EmailAlreadyUsedException;
import com.sourav.exceptions.UserNotFoundException;
import com.sourav.services.UserService;

@RestController
@RequestMapping("/user")
public class UserResource {

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<UserDTO> saveUser(UserDTO userDTO) {
		UserDTO savedUser = null;
		try {
			savedUser = userService.saveUser(userDTO);
		} catch (EmailAlreadyUsedException exception) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<UserDTO>(savedUser, HttpStatus.CREATED);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping
	public ResponseEntity<UserDTO> getUserById(Long id) {
		try {
			return new ResponseEntity<UserDTO>(userService.getUser(id), HttpStatus.FOUND);
		} catch (UserNotFoundException exception) {
			return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		try {
			return new ResponseEntity<List<UserDTO>>(userService.getAllUsers(), HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity<List<UserDTO>>(HttpStatus.NOT_FOUND);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping
	public ResponseEntity deleteUser(Long id) {
		try {
			userService.deleteUser(id);
			return new ResponseEntity(HttpStatus.ACCEPTED);
		} catch (UserNotFoundException exception) {
			return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping
	public ResponseEntity<UserDTO> updateUser(UserDTO userDto) {
		try {
			return new ResponseEntity<UserDTO>(userService.updateUser(userDto), HttpStatus.CREATED);
		} catch (UserNotFoundException exception) {
			return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}
