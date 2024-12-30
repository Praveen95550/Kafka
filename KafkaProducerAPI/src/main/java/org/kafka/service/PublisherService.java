package org.kafka.service;

import java.util.concurrent.CompletableFuture;

import org.kafka.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class PublisherService {

	@Autowired
	private KafkaTemplate kafkaTemplate;
	
	public void sentMessageToTopic(String message) {
		CompletableFuture<org.springframework.kafka.support.SendResult<String,Object>> future = kafkaTemplate.send("NewTopic",message);
		future.whenComplete((result,ex) ->{
			if(ex == null) {
				System.out.println("Sent Message : "+message +" with offset : "+result.getRecordMetadata().offset());
			}else {
				System.out.println("Unable to send Message : "+message +" due to "+ex.getMessage());
			}
		});
	}
	
	public void sentEventsToTopic(Customer customer) {
		CompletableFuture<org.springframework.kafka.support.SendResult<String,Object>> future = kafkaTemplate.send("NewTopic",customer);
		future.whenComplete((result,ex) ->{
			if(ex == null) {
				System.out.println("Sent Message : "+customer.toString() +" with offset : "+result.getRecordMetadata().offset());
			}else {
				System.out.println("Unable to send Message : "+customer.toString() +" due to "+ex.getMessage());
			}
		});
	}
}
