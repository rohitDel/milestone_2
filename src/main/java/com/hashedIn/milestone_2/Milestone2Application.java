package com.hashedIn.milestone_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class Milestone2Application {

	public static void main(String[] args) {
		SpringApplication.run(Milestone2Application.class, args);
	}

}
