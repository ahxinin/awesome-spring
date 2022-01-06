package com.ahxinin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author ahxin
 */
@EnableAsync
@SpringBootApplication
public class AwesomeSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwesomeSpringApplication.class, args);
	}
}
