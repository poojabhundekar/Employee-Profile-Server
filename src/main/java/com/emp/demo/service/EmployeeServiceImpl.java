package com.emp.demo.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.emp.demo.domain.User;
import com.emp.demo.dto.EmployeeDto;
import com.emp.demo.exception.EmployeeException;
import com.emp.demo.repository.EmployeeRepository;

/**
 * 
 * @author Pooja
 *
 */
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<EmployeeDto> getEmployees() {
		try {
			// Repository call to find all Employees

			return employeeRepository.findAll().stream().map(emp -> convertToDto(emp))
					.sorted(Comparator.comparing(EmployeeDto::getFirstName)).collect(Collectors.toList());
		} catch (Exception e) {
			throw new EmployeeException("Error while fetching Employees data");
		}
	}

	@Override
	public EmployeeDto saveEmployee(EmployeeDto emp) {
		try {
			// New employee object is storing by repository
			return convertToDto(employeeRepository.save(convertToDomain(emp)));
		} catch (Exception e) {
			throw new EmployeeException("Error while saving Employee data");
		}
	}

	private EmployeeDto convertToDto(User emp) {
		return new ModelMapper().map(emp, EmployeeDto.class);
	}

	private User convertToDomain(EmployeeDto emp) {
		return new ModelMapper().map(emp, User.class);
	}

	@Override
	public String deleteEmployeeById(String id) {
		try {
			employeeRepository.deleteById(id);
			return "Deleted successfully..!";
		} catch (Exception e) {
			throw new EmployeeException("Could not delete at this moment, Please try again.");
		}
	}

}
