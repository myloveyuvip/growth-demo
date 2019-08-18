package com.yuliyao.activemq.provider;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTextMessage;

import javax.jms.*;

/**
 * @author yuliyao
 * @date 2019/8/18
 */
public class ActiveMQProvider {

    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        Connection connection = null;
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            ActiveMQQueue activeMQQueue = new ActiveMQQueue("myFirstQueue");
            MessageProducer producer = session.createProducer(activeMQQueue);
            TextMessage textMessage = new ActiveMQTextMessage();
            textMessage.setText("hello world4!");
            producer.send(textMessage);
            session.commit();
        } catch (JMSException e) {
            e.printStackTrace();

        }finally {
            connection.close();

        }


    }
}
