package com.pycredit.activeMQ;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JMSProducer {
	private static final Logger logger = LoggerFactory.getLogger(JMSProducer.class);
	
	private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;

	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
	
	private static final String BROKERUEL = ActiveMQConnection.DEFAULT_BROKER_URL;
	
	public static void main(String[] args) throws JMSException {
		//连接工厂
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKERUEL);
		//连接
		Connection connection = connectionFactory.createConnection();
		connection.start();
		//会话
		Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
		//目的地(消息队列)
		Destination destination = session.createQueue("helloword");
		//生产者
		MessageProducer messageProducer = session.createProducer(destination);
		//发送消息
		for(int i = 0;i<10;i++){
			TextMessage textMessage = session.createTextMessage("active 发送消息 "+ i);
			logger.info("发送消息({}):{}",i,textMessage);
			messageProducer.send(textMessage);
		}
		session.commit();
		
		
		
	}
}
