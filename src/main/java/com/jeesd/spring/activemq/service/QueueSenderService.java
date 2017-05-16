package com.jeesd.spring.activemq.service;

import javax.jms.Destination;

public interface QueueSenderService {

	void sendMessage(Destination destination, String msg) throws Exception;
	
	void sendMessage(String msg) throws Exception;
}
