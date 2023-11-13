package com.api.rpfood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodApplication.class, args);
	}

	@GetMapping("/")
	public String index(){
		return "Olá Mundo!";
	}
}
