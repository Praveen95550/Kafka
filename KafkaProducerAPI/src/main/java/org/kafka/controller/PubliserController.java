package org.kafka.controller;

import org.kafka.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PubliserController {
	
	@Autowired
	private PublisherService publisherService;
	
	@GetMapping("/publish/{message}")
	private ResponseEntity<String> publish(@PathVariable String message) {
		publisherService.sentMessageToTopic(message);
		return ResponseEntity.ok("Message submitted sucessfully");
		
		
	}

}
