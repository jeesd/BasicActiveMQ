package com.jeesd.spring.activemq.service;

import javax.jms.Destination;

public interface TopicSenderService {
	
	void publish(Destination topic, String msg) throws Exception;

}
