package com.caetano.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.caetano.workshopmongo.DTO.AuthorDTO;
import com.caetano.workshopmongo.domain.Post;
import com.caetano.workshopmongo.domain.User;
import com.caetano.workshopmongo.repository.PostRepository;
import com.caetano.workshopmongo.repository.UserRepository;

@Configuration
public class Instanciation implements CommandLineRunner {

	@Autowired 
	private UserRepository userRepository;
	
	@Autowired 
	private PostRepository postRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone(("GMT")));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		
		Post post1 = new Post(null,sdf.parse("31/03/2018"), "pariu viagem", "vou viajar para são Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null,sdf.parse("31/03/2018"), "bom dia", "acordei feliz hoje!", new AuthorDTO(maria));
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		postRepository.saveAll(Arrays.asList(post1, post2 ));
	}

	
}
