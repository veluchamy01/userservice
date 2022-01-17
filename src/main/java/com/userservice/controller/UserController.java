/**
 * 
 */
package com.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.entity.User;
import com.userservice.model.UserDetails;
import com.userservice.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author mrvel
 *
 */
@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/")
	public User createUser(@RequestBody User user) {
		log.info("Inside createUser Controller");
		return userService.createUser(user);
	}

	@GetMapping("/{id}")
	public UserDetails getUserwithDepartment(@PathVariable("id") long userId) {
		log.info("Inside getUserwithDepartment Controller");
		return userService.getUserwithDepartment(userId);
	}

}
