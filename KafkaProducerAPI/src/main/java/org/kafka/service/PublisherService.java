package org.kafka.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {

	@Autowired
	private KafkaTemplate kafkaTemplate;
	
	public void sentMessageToTopic(String message) {
		CompletableFuture s = kafkaTemplate.send("Topic_P1",message);
	}
}
