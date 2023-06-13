package com.example.springmicro.reactive;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;


@Configuration
public class SecurityConfig {

	@Bean
	public ReactiveUserDetailsService userDetailsService(UserRepository repository) { 
		return username -> repository.findByName(username) 
				.map(user -> User.withDefaultPasswordEncoder() 
						.username(user.getName()) 
						.password(user.getPassword()) 
						.authorities(user.getRoles().toArray(new String[0])) 
						.build()); 
	}
	@Bean
	CommandLineRunner userLoader(MongoOperations operations) {
		return args -> {
			operations.save(new com.example.springmicro.reactive.User( 
					"educative", "password", Arrays.asList("ROLE_USER")));
		};
	}
}
