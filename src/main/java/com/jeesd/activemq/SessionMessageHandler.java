package com.jeesd.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

public class SessionMessageHandler extends DefaultSessionMessageHandler {

	@Override
	public boolean processMessage(Session session, Message message) throws JMSException {
		TextMessage text = (TextMessage) message;
        if (text != null) {
            System.out.println("接收：" + text.getText());
        }
		return true;
	}

	@Override
	public void asknowledge(Message message) throws JMSException {
		//消息确认
		message.acknowledge();
	}

}
