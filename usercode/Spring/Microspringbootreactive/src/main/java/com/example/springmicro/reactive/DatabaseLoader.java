package com.example.springmicro.reactive;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;


@Component
public class DatabaseLoader {

	@Bean
	CommandLineRunner initialize(MongoOperations mongo) {
		return args -> {
			mongo.save(new Item("alarm clock", " clock", 9.99));
			mongo.save(new Item("TV tray", " TV tray", 14.99));
		};
	}
}
