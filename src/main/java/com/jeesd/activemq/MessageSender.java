package com.jeesd.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 消息发送者
 * @author song
 *
 */
public class MessageSender {

	//发送次数
	public static final int SEND_NUM = 6;
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
			// 创建消息制作者
			 MessageProducer producer = session.createProducer(destination);
			// 设置持久化模式
			 producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	         sendMessage(session, producer);
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
	
	//发送消息
	public static void sendMessage(Session session, MessageProducer producer) throws Exception {
		for(int i=0; i<=SEND_NUM; i++) {
			String message = "MQ测试发送消息第" + (i + 1) + "条";
			TextMessage text = session.createTextMessage(message);
			//打印控制方便调试
			System.out.println(message);
            producer.send(text);
		}
	}
	
	public static void main(String[] args) throws Exception {
        MessageSender.init();
    }
}
