package orguserConsumermanagementapp.Springcore.Prac.userlistener;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import orguserConsumermanagementapp.Springcore.Prac.user.Usermanagemet;

@Component
public class UserListener {
	@KafkaListener(topics="userappsurfing-topic-1",groupId="lob")
	public void listeningMessage(Usermanagemet message) {
		System.out.println("-------------");
		System.out.println("kafka Message:"+message);
	

}
}
