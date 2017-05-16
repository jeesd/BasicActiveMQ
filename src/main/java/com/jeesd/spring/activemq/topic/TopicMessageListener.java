package com.jeesd.spring.activemq.topic;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 消息订阅模式监听
 * @author song
 *
 */
public class TopicMessageListener implements MessageListener {

	public void onMessage(Message message) {
		TextMessage tm = (TextMessage) message;
		try {
			System.out.println("TopicMessageListener \t" + tm.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}

}
