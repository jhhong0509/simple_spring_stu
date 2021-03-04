package com.example.emailsending;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class EmailsendingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailsendingApplication.class, args);
	}

}
