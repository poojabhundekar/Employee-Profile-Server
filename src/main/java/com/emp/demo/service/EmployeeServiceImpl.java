package com.emp.demo.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.emp.demo.domain.User;
import com.emp.demo.dto.UserDto;
import com.emp.demo.exception.EmployeeException;
import com.emp.demo.repository.UserRepository;

/**
 * 
 * @author Pooja
 *
 */
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private UserRepository userRepository;

	/*
	 * Concrete method for get all employees API
	 */
	@Override
	public List<UserDto> getEmployees() {
		try {
			// Repository call to find all Employees

			return userRepository.findAll().stream().map(this::convertFromDomainToDto)
					.sorted(Comparator.comparing(UserDto::getFirstName)).collect(Collectors.toList());
		} catch (Exception e) {
			throw new EmployeeException("Error while fetching Employee data");
		}
	}

	/*
	 * Concrete method for Save employee API
	 */
	@Override
	public UserDto saveEmployee(UserDto emp) {
		try {
			// New employee object is storing by repository
			return convertFromDomainToDto(userRepository.save(convertFromDtoToDomain(emp)));
		} catch (Exception e) {
			throw new EmployeeException("Error while saving " + emp.getFirstName() + " data");
		}
	}

	private UserDto convertFromDomainToDto(User emp) {
		return new ModelMapper().map(emp, UserDto.class);
	}

	private User convertFromDtoToDomain(UserDto emp) {
		return new ModelMapper().map(emp, User.class);
	}

	/*
	 * Concrete method for Delete employee API
	 */
	@Override
	public String deleteEmployeeById(String id) {
		try {
			userRepository.deleteById(id);
			return "Deleted successfully..!";
		} catch (Exception e) {
			throw new EmployeeException("Error while delete Employee data, Please try later.");
		}
	}

}
