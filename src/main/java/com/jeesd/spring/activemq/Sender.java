package com.jeesd.spring.activemq;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

/**
 * 整合spring+MQ
 * @author song
 *
 */
public class Sender {

	public static void main(String[] args) {
        @SuppressWarnings("resource")
		ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
        JmsTemplate jmsTemplate = (JmsTemplate) ctx.getBean("jmsTemplate");
        Destination destination = (Destination)ctx.getBean("queueDestination1");
 
        jmsTemplate.send(destination,new MessageCreator() {
        	public Message createMessage(Session session) throws JMSException {
        		String msg = "Hello Word**********";
                return session.createTextMessage(msg);
            }
        });
    }
}
