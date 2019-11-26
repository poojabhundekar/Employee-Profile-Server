package com.emp.demo.endpoint;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.demo.dto.UserDto;
import com.emp.demo.service.UserService;

/**
 * EmployeeEndpoint is a class for all CRUD operations on EMployee.
 * 
 * @author Pooja B H
 *
 */
@RestController
@RequestMapping(path = "/employees")
public class UserEndpoint {
	
	@Autowired
	private UserService userService;

	/**
	 * @author Pooja
	 * @return
	 */
	@GetMapping(path = "get-users", produces = "application/json")
	public List<UserDto> getEmployees() {
		return userService.getUsers();
	}

	/**
	 * @author Pooja
	 * @return
	 */
	@PostMapping(path = "save-user", produces = "application/json")
	public UserDto saveEmployee(@RequestBody @Valid UserDto emp) {
		return userService.saveUser(emp);
	}
	
	/**
	 * @author Pooja
	 * @return
	 */
	@DeleteMapping(path = "delete-user/{id}")
	public String deleteEmployeeObject(@PathVariable("id") String id) {
		return userService.deleteUserById(id);
	}

}
