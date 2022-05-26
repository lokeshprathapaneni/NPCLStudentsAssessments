package com.mini.consumer.listner;

import org.springframework.kafka.annotation.KafkaListener;

import com.mini.consumer.model.User;

public class UserListner {

	@KafkaListener(topics = "netsurfingzone-topic-1",groupId = "user")
	public void listenForMessage(User user) {
		System.out.println("--------");
		System.out.println("user details from kafka topic "+user);
	}

}
