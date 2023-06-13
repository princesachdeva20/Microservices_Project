
package com.example.springmicro.reactive;

import java.util.Objects;


class CartItem {

	//write your code here 
	private Item item;
	private int quantity;

	CartItem(){
	}

	CartItem(Item item){
		super();
		this.item = item;
		quantity = 1;
	}
	public Item getItem(){
		return item;
	}
	public void setItem(Item item){
		this.item = item;
	}

	public int getQuantity(){
		return quantity;
	}
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}

	public void increment(){
		quantity++;
	}

	public void decrement() {
		quantity--;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CartItem cartItem = (CartItem) o;
		return quantity == cartItem.quantity && Objects.equals(item, cartItem.item);
	}

	@Override
	public int hashCode() {
		return Objects.hash(item, quantity);
	}

	@Override
	public String toString() {
		return "CartItem{" + "item=" + item + ", quantity=" + quantity + '}';
	}
}
