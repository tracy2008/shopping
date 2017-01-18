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
		//���ӹ���
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKERUEL);
		//����
		Connection connection = connectionFactory.createConnection();
		connection.start();
		//�Ự
		Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
		//Ŀ�ĵ�(��Ϣ����)
		Destination destination = session.createQueue("helloword");
		//������
		MessageProducer messageProducer = session.createProducer(destination);
		//������Ϣ
		for(int i = 0;i<10;i++){
			TextMessage textMessage = session.createTextMessage("active ������Ϣ "+ i);
			logger.info("������Ϣ({}):{}",i,textMessage);
			messageProducer.send(textMessage);
		}
		session.commit();
		
		
		
	}
}
