package com.gilbertosantana.workshopmongo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gilbertosantana.workshopmongo.domain.User;
import com.gilbertosantana.workshopmongo.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository repository;
	
	public UserService (UserRepository repository) {
		this.repository = repository;
	}
	
	public List<User> findAll() {
		return repository.findAll();
	}
}