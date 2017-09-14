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
		//���ӹ���
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKERUEL);
		//����
		Connection connection = connectionFactory.createConnection();
		connection.start();
		//�Ự
		Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
		//��Ϣ����
		Destination destination = session.createQueue("helloword");
		//������
		MessageConsumer messageConsumer = session.createConsumer(destination);
		//������Ϣ
		while(true){
			TextMessage textMessage = (TextMessage)messageConsumer.receive(10000);
			if(textMessage != null){
				logger.info("�յ�����Ϣ:{}", textMessage);
			}else{
				break;
			}
		}
		
	}
}
