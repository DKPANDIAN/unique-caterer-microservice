package com.uniquecaterer.service.rest.service;

public interface KafkaProducer {
	
	public static final String TOPIC = "my-kafka-topic";

	public void sendMessage(String message) ;

}
