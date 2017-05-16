package com.jeesd.spring.activemq;

import java.util.Date;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

/**
 * 发布订阅模式
 * @author song
 *
 */
public class TopicSender {

	public static void main(String[] args) {
        @SuppressWarnings("resource")
		ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
        JmsTemplate jmsTemplate = (JmsTemplate) ctx.getBean("topicJmsTemplate");
        Destination topic =  (Destination) ctx.getBean("topicDestination"); 
        
        jmsTemplate.send(topic, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
        		String msg = "topic---messagecurrent system time: " + new Date().getTime();
                return session.createTextMessage(msg);
            }
        });
    }
}
