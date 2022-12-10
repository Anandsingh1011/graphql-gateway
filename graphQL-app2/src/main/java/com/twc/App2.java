package com.twc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication

@ComponentScan({ "com.twc" })
@EntityScan("com.twc")

@EnableMongoRepositories

public class App2 {

	public static void main(String[] args) {
		SpringApplication.run(App2.class, args);
	}

}
