package com.example.springmicro.reactive;

import java.util.stream.Collectors;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.stereotype.Service;


@Service
class InventoryService {
 
 //write code for task 7,8,9 here
    private ItemRepository itemRepo;
    private CartRepository cartRepo;

    InventoryService(){
        super();
    }
    InventoryService( ItemRepository _itemRepo , CartRepository _cartRepo){
        this.itemRepo = _itemRepo;
        this.cartRepo =_cartRepo;
    }
    public Mono<Cart> getCartRepo(String cartId) {
        return this.cartRepo.findById(cartId);
    }
    public Flux<Item> getItemRepo(){
        return this.itemRepo.findAll();
    }

    public Mono<Item> saveItem(Item newitem){
        return this.itemRepo.save(newitem);
    }

    public Mono<Void>  deleteItem(String itemId){
        return this.itemRepo.deleteById(itemId);
    }

    public Mono<Cart> addItemtoCart(String cartId, String itemId){
        return this.cartRepo.findById(cartId)
                .defaultIfEmpty(new Cart(cartId))
                .flatMap(cart -> cart.getCartItems().stream()
                        .filter(cartItem -> cartItem.getItem().getId().equals(itemId))
                        .findAny()
                        .map(cartItem -> {cartItem.decrement(); return Mono.just(cart);})
                        .orElse(Mono.empty()))
                .map(cart -> new Cart(cart.getId(),cart.getCartItems().stream()
                        .filter(cartItem -> cartItem.getQuantity()>0)
                        .collect(Collectors.toList())))
                .flatMap(cart -> this.cartRepo.save(cart));
    }
}
