package com.example.springmicro.reactive;

import reactor.core.publisher.Mono;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
//write your code here
interface ItemRepository extends ReactiveCrudRepository<Item, String> {
    Mono<Item>findByName(String name);
}
