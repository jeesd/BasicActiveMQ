package com.jeesd.spring.activemq.queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 队列接收监听
 * @author song
 *
 */
public class QueueMessageListener implements MessageListener {

	public void onMessage(Message message) {
		TextMessage tm = (TextMessage) message;
		try {
			System.out.println("QueueMessageListener \t" + tm.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
