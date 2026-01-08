package com.smart_school.smart_school_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SmartSchoolManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartSchoolManagementApplication.class, args);
	}

}
