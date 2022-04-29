package org.userconsumerapp.springcore.prac.user.consumer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.userconsumerapp.springcore.prac.user.model.User;

import com.fasterxml.jackson.databind.deser.std.StringDeserializer;

@Configuration
public class UserConsumerConfiguration {
	
	@Bean
	public ConsumerFactory<String, User> consumerFactory(){
		Map<String,Object> configMap=new HashMap<>();
		configMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
		configMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
		configMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		configMap.put(JsonDeserializer.TRUSTED_PACKAGES,"org.usermanagementapp.springcore.prac.usermagnementmodel");
		return new DefaultKafkaConsumerFactory<>(configMap);
	}
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String,User> kafkaListnerContainerFactory(){
		ConcurrentKafkaListenerContainerFactory<String,User> factory=new ConcurrentKafkaListenerContainerFactory<String,User>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}


}
