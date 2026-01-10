package com.gilbertosantana.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gilbertosantana.workshopmongo.domain.User;
import com.gilbertosantana.workshopmongo.dto.UserDTO;
import com.gilbertosantana.workshopmongo.repository.UserRepository;
import com.gilbertosantana.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	private final UserRepository repository;
	
	public UserService (UserRepository repository) {
		this.repository = repository;
	}
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public void delete(String id) {
		Optional<User> obj = repository.findById(id);
		if(!obj.isPresent()) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		repository.deleteById(id);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}