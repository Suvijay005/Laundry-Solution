package com.app.service;

import java.util.List;

import com.app.pojos.Role;
import com.app.pojos.User;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User addUser(User transientUser);
    User editUserDetails(User detachedUser);
    String deleteUser(Long id);
    boolean changeRole(Role role, String email);
    
}
