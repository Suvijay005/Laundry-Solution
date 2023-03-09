package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.custom_exceptions.UserAlreadyExistsException;
import com.app.pojos.Role;
import com.app.pojos.User;
import com.app.repository.UserRepository;
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	
	
	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll() ;
	}

	@Override
	public User getUserById(Long id) {
		return userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid id!"));
	}
	
	 @Override
	public User addUser(User transientUser) {
	if(userRepo.existsByEmail(transientUser.getEmail())){
		throw new UserAlreadyExistsException("Email already exists!");
	}
	transientUser.setPassword(transientUser.getEmail());
		return userRepo.save(transientUser);
	}
	
	 
	 @Override
	public User editUserDetails(User detachedUser) {
		if(userRepo.existsById(detachedUser.getId())) {
		return userRepo.save(detachedUser);
		}
		throw new ResourceNotFoundException("updation failed!invalid id");
	}
	
	 @Override
	public String deleteUser(Long id) {
		if(userRepo.existsById(id)) {
		userRepo.deleteById(id);
			return "User deleted successfully";
		}
		return "Deletion failed!Invalid id";
	}
	 
	 @Override
	public boolean changeRole(Role role, String email) {
		User user = userRepo.findByEmail(email)
				.orElseThrow(() -> new ResourceNotFoundException("wrong email id"));
		user.setRole(role);
		return true;
		
	}
	 
	

}
