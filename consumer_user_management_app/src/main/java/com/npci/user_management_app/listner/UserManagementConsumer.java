package com.npci.user_management_app.listner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.npci.user_management_app.entity.User;

@Component
public class UserManagementConsumer {

	Logger LOGGER = LoggerFactory.getLogger("UserManagementConsumer.class");

	@KafkaListener(topics = "usermanagement-topic-1", groupId = "usr")
	public void listeningMesg(User user) {
		LOGGER.info("The Kafka message is = " + user);
	}

}
