# Microservices_Project
Capstone Project
Project Started By:
Create the Item Entity
Create the Repository for the Item Entity
Create the User Class
Create the repository for the user Class
Create a Cart Item Class
Create a Cart for the inventory
Create an Inventory Service like Create a saveItem() and deleteItem() method
Created an add Item method to add items to the cart by passing cart id.

Add Item in the repository, the code breakdown
public Mono<Cart> addItemtoCart(String cartId, String itemId) {
    return this.cartRepo.findById(cartId)  //This line retrieves the cart from the repository using the provided cartId.
.defaultIfEmpty(new Cart(cartId)) //If no cart is found with the given cartId, a default cart is created with the provided cartId.
.flatMap(cart -> cart.getCartItems().stream() //Once the cart is retrieved (either from the repository or created as a default cart), 
                                                the method proceeds to work with the cart's items.
.filter(cartItem -> cartItem.getItem().getId().equals(itemId)) //Filters the cart items to find the item with the matching itemId.
.findAny() //Finds any cart item that matches the filter condition.
.map(cartItem -> {cartItem.increment(); return Mono.just(cart);}) //If a matching cart item is found, it increments its quantity and 
                                                                    returns the modified cart wrapped in a Mono.
.orElse(Mono.empty())) //If no matching cart item is found, it returns an empty Mono.
.map(cart -> new Cart(cart.getId(), cart.getCartItems().stream()
                .filter(cartItem -> cartItem.getQuantity() > 0)
                .collect(Collectors.toList()))) //After the modification (incrementing quantity) or if no modification was made, 
                                                  it creates a new Cart object based on the original cart, 
                                                   filtering out cart items with a quantity of 0 or less.
  .flatMap(cart -> this.cartRepo.save(cart)); //Finally, it saves the modified or new cart to the repository and 
                                                returns the resulting Mono that represents the updated cart.
  
In Similar way, we can delete an Item present in the cart with a perticular cart ID and item ID

