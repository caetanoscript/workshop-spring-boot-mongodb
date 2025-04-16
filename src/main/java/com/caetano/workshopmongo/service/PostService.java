package com.caetano.workshopmongo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caetano.workshopmongo.domain.Post;
import com.caetano.workshopmongo.repository.PostRepository;
import com.caetano.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	
	
	public Post findById(String id) {
	    Optional<Post> userOptional = repo.findById(id);
	    if (!userOptional.isPresent()) {
	        throw new ObjectNotFoundException("Objeto não encontrado");
	    }
	    return userOptional.get();  
	}
	
	
}
