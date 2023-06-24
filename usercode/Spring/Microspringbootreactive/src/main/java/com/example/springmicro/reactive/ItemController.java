package com.example.springmicro.reactive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
    public class ItemController {

        @Autowired
        private MongoOperations mongo;

        @PostMapping("/add-item")
        public String addItem(@RequestParam("id") String id,
                              @RequestParam("name") String name,
                              @RequestParam("description") String description,
                              @RequestParam("price") double price) {

            Item item = new Item(id,name, description, price);
            mongo.save(item);

            // Redirect to a confirmation page or any other appropriate page
            return "./item-added";
        }

    }
