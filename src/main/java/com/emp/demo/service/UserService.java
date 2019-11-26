package com.emp.demo.service;

import java.util.List;

import com.emp.demo.dto.UserDto;

public interface UserService {
	/**
	 * getUsers is a method to get list of all users
	 * 
	 * @author Pooja B H
	 * @return
	 */
	List<UserDto> getUsers();

	/**
	 * saveUser is a method to save user to database
	 * 
	 * @author Pooja B H
	 * @return
	 */
	UserDto saveUser(UserDto emp);

	/**
	 * deleteUserById is a method to delete user data from database
	 * 
	 * @author Pooja B H
	 * @return
	 */
	String deleteUserById(String id);

}
