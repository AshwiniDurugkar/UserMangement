package com.ashwini.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashwini.entity.User;
import com.ashwini.service.UserService;

import lombok.Data;


@RestController
public class RegistrationRestController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/register/{userid}" ,produces ="application/json")
	public ResponseEntity<User> get(@PathVariable Integer userid){
		try {
		User user = userService.get(userid);
		return new ResponseEntity<User>(user,HttpStatus.OK);
      }
	 catch(NoSuchElementException e)
	 {
		 return new ResponseEntity<User>(HttpStatus.NOT_FOUND);

     }
	}
	 @PostMapping(value = "/register" , produces = "application/json")
	 public void add(@RequestBody User user)
	 {
		 userService.saveUser(user);
	 }
	 
	 @PutMapping("/register/{userid}")
	 public ResponseEntity<?> update(@RequestBody User user, @PathVariable Integer userid){
		 try {
			 User existUser = userService.get(userid);
			 userService.saveUser(user);
			 return new ResponseEntity<>(HttpStatus.OK);
		 }
		 catch(NoSuchElementException e)
		 {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		 }
	 }
	 @DeleteMapping("/register/{userid}")
	 public void delete(@PathVariable Integer userid) {
		 userService.delete(userid);
	 }
}
	