package com.emp.demo.service;

import java.util.List;

import com.emp.demo.dto.UserDto;

public interface EmployeeService {
	/**
	 * getEmployees is a method to get list of all employees
	 * 
	 * @author Pooja B H
	 * @return
	 */
	List<UserDto> getEmployees();

	/**
	 * saveEmployee is a method to save employee to database
	 * 
	 * @author Pooja B H
	 * @return
	 */
	UserDto saveEmployee(UserDto emp);

	/**
	 * deleteEmployeeById is a method to delete employee data from database
	 * 
	 * @author Pooja B H
	 * @return
	 */
	String deleteEmployeeById(String id);

}
