package org.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaListnerService {

	@KafkaListener(topics = "NewTopic")
	public void consume1(String message) {
		System.out.println("consumer1 : "+message);
	}
	
	@KafkaListener(topics = "NewTopic")
	public void consume2(String message) {
		System.out.println("consumer2 : "+message);
	}
	
	@KafkaListener(topics = "NewTopic")
	public void consume3(String message) {
		System.out.println("consumer3 : "+message);
	}
}
