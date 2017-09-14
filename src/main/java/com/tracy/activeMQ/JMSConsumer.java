package com.tracy.activeMQ;

import java.sql.Connection;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.print.attribute.standard.Destination;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JMSConsumer {
	private static final Logger logger = LoggerFactory.getLogger(JMSConsumer.class);
	
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
		//消息队列
		Destination destination = session.createQueue("helloword");
		//消费者
		MessageConsumer messageConsumer = session.createConsumer(destination);
		//接收消息
		while(true){
			TextMessage textMessage = (TextMessage)messageConsumer.receive(10000);
			if(textMessage != null){
				logger.info("收到的消息:{}", textMessage);
			}else{
				break;
			}
		}
		
	}
}
