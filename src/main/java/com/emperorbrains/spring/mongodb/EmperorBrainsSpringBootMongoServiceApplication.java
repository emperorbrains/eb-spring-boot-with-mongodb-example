package com.emperorbrains.spring.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import lombok.extern.slf4j.Slf4j;

/**
 * @author RajuKhunt
 * 
 */

@Slf4j
@EnableFeignClients
@SpringBootApplication
@EnableMongoRepositories
public class EmperorBrainsSpringBootMongoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmperorBrainsSpringBootMongoServiceApplication.class, args);
		log.info("EmperorBrains Spring Boot with MongoDB is up to runining");
	}
}
