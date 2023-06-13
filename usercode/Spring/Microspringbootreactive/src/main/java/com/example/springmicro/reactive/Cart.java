package com.example.springmicro.reactive;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;

class Cart {

	//write your code here
	private String id;
	private List<CartItem> cartItems;

	public Cart(){
	}

	public Cart (String _id){
		this.id = _id;
	}
	public Cart( String id, List<CartItem> cartItem){
		this.id = id;
		this.cartItems = cartItem;
	}

	public String getId(){
		return id;
	}
	public void setId( String _id ){
		this.id = _id;
	}

	public List<CartItem> getCartItems(){
		return cartItems;
	}

	public void setCartItems(List<CartItem> _cartItem){
		this.cartItems = _cartItem;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Cart cart = (Cart) o;
		return Objects.equals(id, cart.id) && Objects.equals(cartItems, cart.cartItems);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, cartItems);
	}

	@Override
	public String toString() {
		return "Cart{" + "id='" + id + '\'' + ", cartItems=" + cartItems + '}';
	}
}
