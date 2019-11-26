package com.emp.demo.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.demo.domain.User;
import com.emp.demo.dto.UserDto;
import com.emp.demo.exception.UserException;
import com.emp.demo.repository.UserRepository;

/**
 * 
 * @author Pooja
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	/*
	 * Concrete method for get all users API
	 */
	@Override
	public List<UserDto> getUsers() {
		try {
			// Repository call to find all users

			return userRepository.findAll().stream().map(this::convertFromDomainToDto)
					.sorted(Comparator.comparing(UserDto::getFirstName)).collect(Collectors.toList());
		} catch (Exception e) {
			throw new UserException("Error while fetching Employee data");
		}
	}

	/*
	 * Concrete method for Save user API
	 */
	@Override
	public UserDto saveUser(UserDto user) {
		try {
			// New user object is storing by repository
			return convertFromDomainToDto(userRepository.save(convertFromDtoToDomain(user)));
		} catch (Exception e) {
			throw new UserException("Error while saving " + user.getFirstName() + " data");
		}
	}

	private UserDto convertFromDomainToDto(User emp) {
		return new ModelMapper().map(emp, UserDto.class);
	}

	private User convertFromDtoToDomain(UserDto emp) {
		return new ModelMapper().map(emp, User.class);
	}

	/*
	 * Concrete method for Delete user API
	 */
	@Override
	public String deleteUserById(String id) {
		try {
			userRepository.deleteById(id);
			return "Deleted successfully..!";
		} catch (Exception e) {
			throw new UserException("Error while delete Employee data, Please try later.");
		}
	}

}
