package com.jahcode.SpringChallengeApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 Taken from youtube tutorial:
 youtube : https://www.youtube.com/watch?v=NQA5mKtm8DQ
*/

@SpringBootApplication
public class SpringChallengeAppApplication {

	public static void main(String[] args) {

		System.out.println("Starting app...");

		SpringApplication.run(SpringChallengeAppApplication.class, args);
	}

}
