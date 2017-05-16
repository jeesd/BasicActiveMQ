package com.jeesd.spring.activemq;

import javax.jms.Destination;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.jeesd.spring.activemq.service.QueueSenderService;
import com.jeesd.spring.activemq.service.TopicSenderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class SpringJmsTest {
	
	/**
	 * 队列消息生产者
	 */
	@Autowired
	private QueueSenderService sender;
	
	/**
	 * 主题 jeesd.topic
	 */
	@Autowired
	@Qualifier("topicDestination")
	private Destination topic;
	
	@Autowired
	@Qualifier("queueDestination1")
	private Destination queueDestination1;

	/**
	 * 主题消息发布者
	 */
	@Autowired
	private TopicSenderService topicSender;

	
	/**
	 * 测试生产者向默认发送消息
	 * @throws Exception 
	 */
	@Test
	public void testProduce() throws Exception {
		String msg = "Hello world!";
		sender.sendMessage(queueDestination1,msg);
	}

	
	@Test
	public void testTopic() throws Exception {
		topicSender.publish(topic, "Hello T-To-Top-Topi-Topic!");
	}
}
