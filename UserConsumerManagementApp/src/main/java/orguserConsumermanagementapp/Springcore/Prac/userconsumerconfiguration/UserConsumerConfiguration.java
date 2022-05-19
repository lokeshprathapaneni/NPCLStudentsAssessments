package orguserConsumermanagementapp.Springcore.Prac.userconsumerconfiguration;

import java.util.HashMap;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import orguserConsumermanagementapp.Springcore.Prac.user.Usermanagemet;

@Configuration
public class UserConsumerConfiguration {
	@Bean
	public ConsumerFactory<String, Usermanagemet> consumerFactory(){
		HashMap<String,Object> configMap=new HashMap<>();
		configMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
		configMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
		configMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		configMap.put(JsonDeserializer.TRUSTED_PACKAGES,"orgusermanagementapp.Springcore.Prac.usermanagementmodel");
		return new DefaultKafkaConsumerFactory<>(configMap);
	}
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String,Usermanagemet> kafkaListnerContainerFactory(){
		ConcurrentKafkaListenerContainerFactory<String,Usermanagemet> factory=new ConcurrentKafkaListenerContainerFactory<String,Usermanagemet>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}

}
