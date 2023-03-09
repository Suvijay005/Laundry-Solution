package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Role;
import com.app.pojos.User;
import com.app.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public List<User> fetchAllUsers() {
		return userService.getAllUsers();
	}

	@PostMapping
	public User addUserDetails(@RequestBody User transientUser) {
		return userService.addUser(transientUser);

	}
	
	@GetMapping("/{id}")
	public User fetchUserDetails(@PathVariable Long id) {
		return userService.getUserById(id);
	}
	
	@PutMapping
	public User modifyUserDetails(@RequestBody User detachedUser) {
		return userService.editUserDetails(detachedUser);
	}
	
	@DeleteMapping("/{id}")
	public String deleteUserById(@PathVariable Long id) {
		return userService.deleteUser(id);
	}
	
//	@PostMapping("/{role}/{email}")
//	public boolean changeUserRole(@PathVariable Role role, @PathVariable String email) {
//		return userService.changeRole(role, email);
//	}
	

}
