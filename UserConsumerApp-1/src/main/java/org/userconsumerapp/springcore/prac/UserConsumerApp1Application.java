package org.userconsumerapp.springcore.prac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class UserConsumerApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(UserConsumerApp1Application.class, args);
	}

}
