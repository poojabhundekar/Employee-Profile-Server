package com.emp.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.emp.demo.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}
