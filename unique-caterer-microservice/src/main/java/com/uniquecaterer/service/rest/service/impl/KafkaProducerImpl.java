package com.uniquecaterer.service.rest.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.uniquecaterer.service.rest.service.KafkaProducer;

@Service
public class KafkaProducerImpl implements KafkaProducer {


	private static final Logger logger = LoggerFactory.getLogger(KafkaProducerImpl.class);

	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

	@Override
	public void sendMessage(String message) {
		  logger.debug(String.format("KafkaProducerImpl::sendMessage() processing %s", message));
		  this.kafkaTemplate.send(TOPIC, message);
	}
		
}
