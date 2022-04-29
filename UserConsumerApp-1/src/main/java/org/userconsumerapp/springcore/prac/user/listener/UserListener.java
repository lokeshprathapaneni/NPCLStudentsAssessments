package org.userconsumerapp.springcore.prac.user.listener;



import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.userconsumerapp.springcore.prac.user.model.User;

@Component
public class UserListener {
	@KafkaListener(topics="netsurfingzone-topic-1",groupId="lob")
	public void listeningMessage(User message) {
		System.out.println("-------------");
		System.out.println("kafka Message:"+message);
	}

}
