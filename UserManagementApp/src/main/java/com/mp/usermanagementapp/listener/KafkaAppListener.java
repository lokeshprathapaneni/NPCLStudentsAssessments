package com.mp.usermanagementapp.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.mp.usermanagementapp.entity.User;

@Component
public class KafkaAppListener {
	@KafkaListener(topics = "netsurfingzone-topic-1", groupId = "UMA")
	public void listenForMessage(User user) {
		System.out.println("------------------");
		System.out.println("User: "+user);
	}
}
