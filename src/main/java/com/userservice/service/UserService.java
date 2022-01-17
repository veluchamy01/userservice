/**
 * 
 */
package com.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userservice.entity.User;
import com.userservice.model.Department;
import com.userservice.model.UserDetails;
import com.userservice.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author mrvel
 *
 */
@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public User createUser(User user) {
		log.info("Inside createUser Service");
		return userRepository.save(user);
	}

	public UserDetails getUserwithDepartment(long userId) {
		log.info("Inside getUserwithDepartment Service");
		HttpHeaders httpHeaders = new HttpHeaders();
		HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
		
		UserDetails userDetails = new UserDetails();
		
		User user = userRepository.findByUserId(userId);
		
		ResponseEntity<Department> departmentDetails = restTemplate.exchange("http://localhost:9001/departments/"+user.getDepartmentId(), HttpMethod.GET, httpEntity, Department.class);
		
		Department department = departmentDetails.getBody();
		
		userDetails.setUser(user);
		userDetails.setDepartment(department);
		
		return userDetails;
	}

}
