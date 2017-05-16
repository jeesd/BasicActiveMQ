package com.jeesd.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 消息接收者
 * @author song
 *
 */
public class MessageReceiver {
	
	//tcp连接地址
	public static final String BROKER_URL = "tcp://localhost:61616";
	//目标，在ActiveMQ管理员控制台创建
	public static final String DESTINATION = "jeesd.queue";

	public static void init() throws Exception {
		// 创建链接工厂
		Session session = null;
		Connection connection = null;
		try {
			ConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, 
					ActiveMQConnection.DEFAULT_PASSWORD, BROKER_URL);
			// 通过工厂创建一个连接
			connection = factory.createConnection();
			// 启动连接
			connection.start();
			// 创建一个session会话
			session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
			// 创建一个消息队列
			Destination destination = session.createQueue(DESTINATION);
			// 消费消息制作者
			MessageConsumer consumer = session.createConsumer(destination);
			//创建消息监听器
			ReceiverMessageListener receiverListener = new ReceiverMessageListener();
			SessionMessageHandler messageHandler = new SessionMessageHandler();
			receiverListener.setMessageHandler(messageHandler);
			receiverListener.setSession(session);
			consumer.setMessageListener(receiverListener);
			/*while (true) {
                // 接收数据的时间（等待） 100 ms
                Message message = consumer.receive(1000 * 100);               
                TextMessage text = (TextMessage) message;
                if (text != null) {
                    System.out.println("接收：" + text.getText());
                } else {
                    break;
                }
            }*/
			// 休眠100ms再关闭
            Thread.sleep(1000 * 100);
			// 提交会话
	         session.commit();
		} catch(Exception e) {
			throw new RuntimeException(e);
		} finally {
            // 关闭释放资源
            if (session != null) {
                session.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
	}
	
	public static void main(String[] args) throws Exception {
		MessageReceiver.init();
	}
}
