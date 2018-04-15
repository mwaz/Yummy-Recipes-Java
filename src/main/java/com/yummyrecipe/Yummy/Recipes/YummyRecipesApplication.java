package com.yummyrecipe.Yummy.Recipes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class YummyRecipesApplication {

	public static void main(String[] args) {

		 SpringApplication.run(YummyRecipesApplication.class, args);
	}
}
