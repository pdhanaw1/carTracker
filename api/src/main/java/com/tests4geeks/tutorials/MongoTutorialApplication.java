package com.tests4geeks.tutorials;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages ={"com.tests4geeks.tutorials"})
@EnableMongoRepositories("com.tests4geeks.tutorials.repository")
public class MongoTutorialApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(MongoTutorialApplication.class, args);
	}
	
	public void run() {
	}
}
