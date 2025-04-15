package com.caetano.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caetano.workshopmongo.domain.User;
import com.caetano.workshopmongo.repository.UserRepository;
import com.caetano.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
	    Optional<User> userOptional = repo.findById(id);
	    if (!userOptional.isPresent()) {
	        throw new ObjectNotFoundException("Objeto não encontrado");
	    }
	    return userOptional.get();  
	}

}
