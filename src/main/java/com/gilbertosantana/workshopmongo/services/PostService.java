package com.gilbertosantana.workshopmongo.services;

import java.util.Date;
import java.util.List;
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
	
	public List<Post> findByTitle(String text) {
		return repository.searchTitle(text);
		//return repository.findByTitleIgnoreCase(text);	
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repository.fullSearch(text, minDate, maxDate);
	}
}