package org.npci.usermanagement.messageconsumer;

import org.npci.usermanagement.entity.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

	@KafkaListener(topics = "netsurfingzone-topic-1", groupId = "mini")
	public void listener(User user) {
		System.out.println("Kafka message is: "+user);
	}
}
