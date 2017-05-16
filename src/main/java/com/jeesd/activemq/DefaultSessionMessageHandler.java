package com.jeesd.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
/**
 * 默认实现
 * @author song
 *
 */
public abstract class DefaultSessionMessageHandler {

	public abstract boolean processMessage(Session session, Message message) throws JMSException;
	
	public abstract void asknowledge(Message message) throws JMSException;
}
