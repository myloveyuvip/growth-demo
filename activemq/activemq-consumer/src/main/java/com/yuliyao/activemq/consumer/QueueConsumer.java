package com.yuliyao.activemq.consumer;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.*;

/**
 * @author yuliyao
 * @date 2019/8/19
 */
public class QueueConsumer {

    public static void main(String[] args) {

        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        Connection connection = null;
        try {
            connection = activeMQConnectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            ActiveMQQueue activeMQQueue = new ActiveMQQueue("myFirstQueue");
            MessageConsumer consumer =
                    session.createConsumer(activeMQQueue);
            TextMessage receive = (TextMessage)consumer.receive();
            System.out.println(receive.getText());
            session.commit();
            session.close();
            connection.close();

        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
