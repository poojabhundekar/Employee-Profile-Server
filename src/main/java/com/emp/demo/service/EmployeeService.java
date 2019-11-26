package com.emp.demo.service;

import java.util.List;

import com.emp.demo.dto.EmployeeDto;

public interface EmployeeService {
	/**
	 * getEmployees is a method to get list of all employees
	 * 
	 * @author Pooja B H
	 * @return
	 */
	List<EmployeeDto> getEmployees();

	/**
	 * saveEmployee is a method to save employee to database
	 * 
	 * @author Pooja B H
	 * @return
	 */
	EmployeeDto saveEmployee(EmployeeDto emp);

	/**
	 * deleteEmployeeById is a method to delete employee data from database
	 * 
	 * @author Pooja B H
	 * @return
	 */
	String deleteEmployeeById(String id);

}
