package com.jeesd.spring.activemq.service;

import javax.jms.Destination;

public interface TopicReceiverService {

	void receive(Destination destination) throws Exception;
}
