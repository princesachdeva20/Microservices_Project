package com.example.springmicro.reactive;

import reactor.core.publisher.Mono;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.result.view.Rendering;


@Controller
public class HomeController {

	private final InventoryService inventoryService;

	public HomeController(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

	//Write code for task: 11 here
	OAuth2AuthorizedClient authorizedClient;
	OAuth2User oauth2User;
	@GetMapping
	Mono<Rendering>home(@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient,
						@AuthenticationPrincipal OAuth2User){

		return Mono.just(Rendering.view("home.html")
				.modelAttribute("items", this.inventoryService.getInventory())
				.modelAttribute("cart", this.inventoryService.getCart(cartName(oauth2User))
						.defaultIfEmpty(new Cart(cartName(oauth2User))))
				.modelAttribute("userName", oauth2User.getName())
				.modelAttribute("authorities", oauth2User.getAuthorities())
				.modelAttribute("clientName", authorizedClient.getClientRegistration().getClientName())
				.modelAttribute("userAttributes", oauth2User.getAttributes())
				.build());
	}
	
    //Write code for task: 12 here
	@PostMapping
	Mono<String>addToCart(@AuthenticationPrincipal OAuth2User, @PathVariable String id){


	}



    @PostMapping
	@ResponseBody
	Mono<Item> createItem(@RequestBody Item newItem) {
		return this.inventoryService.saveItem(newItem);
	}

	@DeleteMapping("/{id}")
	@ResponseBody
	Mono<Void> deleteItem(@PathVariable String id) {
		return this.inventoryService.deleteItem(id);
	}

	private static String cartName(OAuth2User oAuth2User) {
		return oAuth2User.getName() + "'s Cart";
	}
}
