package com.jeesd.spring.activemq.service.impl;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.jeesd.spring.activemq.service.QueueSenderService;

@Service
public class QueueSenderServiceImpl implements QueueSenderService {
	
	@Autowired
	private JmsTemplate jmsTemplate;

	public void sendMessage(Destination destination, final String msg) throws Exception {
		System.out.println("向队列" + destination.toString() + "发送了消息------------" + msg);
	    jmsTemplate.send(destination, new MessageCreator() {
	      public Message createMessage(Session session) throws JMSException {
	        return session.createTextMessage(msg);
	      }
	    });		
	}

	public void sendMessage(final String msg) throws Exception {
		String destination =  jmsTemplate.getDefaultDestination().toString();
	    System.out.println("向队列" +destination+ "发送了消息------------" + msg);
	    jmsTemplate.send(new MessageCreator() {
	      public Message createMessage(Session session) throws JMSException {
	        return session.createTextMessage(msg);
	      }
	    });
		
	}

}
