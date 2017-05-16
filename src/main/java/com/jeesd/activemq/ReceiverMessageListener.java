package com.jeesd.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;

/**
 * 接收者监听器
 * @author song
 *
 */
public class ReceiverMessageListener implements MessageListener {

	private SessionMessageHandler messageHandler;
	private Session session;
	
	public void onMessage(Message message) {
		boolean result;
		try {
			result = messageHandler.processMessage(session, message);
			if(result) {
				//确认接收
				messageHandler.asknowledge(message);
			}
		} catch(JMSException e) {
			e.printStackTrace();
		}		
	}

	public SessionMessageHandler getMessageHandler() {
		return messageHandler;
	}

	public void setMessageHandler(SessionMessageHandler messageHandler) {
		this.messageHandler = messageHandler;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}
