package com.gilbertosantana.workshopmongo.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gilbertosantana.workshopmongo.domain.Post;
import com.gilbertosantana.workshopmongo.repository.PostRepository;
import com.gilbertosantana.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	private final PostRepository repository;
	
	public PostService (PostRepository repository) {
		this.repository = repository;
	}
	
	public Post findById(String id) {
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}