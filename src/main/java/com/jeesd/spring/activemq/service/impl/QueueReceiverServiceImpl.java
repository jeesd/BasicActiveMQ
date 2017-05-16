package com.jeesd.spring.activemq.service.impl;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.jeesd.spring.activemq.service.QueueReceiverService;

@Service
public class QueueReceiverServiceImpl implements QueueReceiverService {
	
	@Autowired
	private JmsTemplate jmsTemplate;

	public void receive(Destination destination) throws Exception {
		TextMessage tm = (TextMessage) jmsTemplate.receive(destination);
		try {
			System.out.println("从队列" + destination.toString() + "收到了消息：\t"
					+ tm.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}

}
