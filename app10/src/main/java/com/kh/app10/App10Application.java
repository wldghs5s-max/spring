package com.kh.app10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class App10Application {

	public static void main(String[] args) {
		SpringApplication.run(App10Application.class, args);
	}

}
