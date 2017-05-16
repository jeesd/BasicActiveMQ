package com.jeesd.spring.activemq.service.impl;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.jeesd.spring.activemq.service.TopicSenderService;

@Service
public class TopicSenderServiceImpl implements TopicSenderService {
	
	@Autowired
	private JmsTemplate topicJmsTemplate;

	public void publish(final Destination topic, final String msg) throws Exception {
		topicJmsTemplate.send(topic, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				System.out.println("topic name 是" + topic.toString()
						+ "，发布消息内容为:\t" + msg);
				return session.createTextMessage(msg);
			}
		});
		
	}

}
