package com.jeesd.spring.activemq.service;

import javax.jms.Destination;

public interface QueueReceiverService {

	void receive(Destination destination) throws Exception;
}
