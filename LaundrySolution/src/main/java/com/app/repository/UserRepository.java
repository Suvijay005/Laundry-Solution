package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Role;
import com.app.pojos.User;

public interface UserRepository extends JpaRepository<User, Long>{
  
	boolean existsByEmail(String email);
	Optional<User> findByEmail(String email);
	@Modifying
	@Query("update User u set u.role = ?1 where u.email = ?2")
	void updateUserRole(Role role, String email);
	Optional<User> findByEmailAndPassword(String email,String pass);
	
}
