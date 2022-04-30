package com.mp.consumerapp.listner;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.mp.usermanagementapp.entity.User;



@Component
public class KafkaConsumer {

	@KafkaListener(topics = "netsurfingzone-topic-1",groupId = "user")
	public void listenForMessage(User user) {
		System.out.println("--------");
		System.out.println("user details from kafka topic "+user);
	}
}
