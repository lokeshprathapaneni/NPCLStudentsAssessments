package orguserConsumermanagementapp.Springcore.Prac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class UserConsumerManagementAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserConsumerManagementAppApplication.class, args);
	}

}
