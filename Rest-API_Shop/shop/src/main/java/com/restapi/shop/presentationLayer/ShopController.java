package com.restapi.shop.presentationLayer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {

    @GetMapping
    public String home(){
        return "Home page";
    }
}
