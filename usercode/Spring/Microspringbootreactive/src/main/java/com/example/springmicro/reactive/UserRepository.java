package com.example.springmicro.reactive;

import org.springframework.data.repository.CrudRepository;
import reactor.core.publisher.Mono;
//write your code here
public interface UserRepository extends CrudRepository <User, String>{
    Mono<User> findByName(String name);
}
