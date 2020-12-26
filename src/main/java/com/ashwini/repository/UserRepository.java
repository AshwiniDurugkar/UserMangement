package com.ashwini.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashwini.entity.User;

public interface UserRepository extends JpaRepository<User , Serializable>{
	
	User findByEmailId(String emailId);
	User findByEmailIdAndPassword(String emailId, String password);
	

}
