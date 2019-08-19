package com.yuliyao.activemq.provider;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.apache.activemq.command.ActiveMQTopic;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;

/**
 * @author yuliyao
 * @date 2019/8/19
 */
public class TopicProvider {

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = new ActiveMQConnectionFactory("tcp://localhost:61616").createConnection();
            Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            ActiveMQTopic activeMQTopic = new ActiveMQTopic("firstTopic");
            MessageProducer producer =
                    session.createProducer(activeMQTopic);
            ActiveMQTextMessage activeMQTextMessage = new ActiveMQTextMessage();
            for (int i = 0; i < 10; i++) {
                activeMQTextMessage.setText("hello world!I am first topic" + i);
                producer.send(activeMQTextMessage);
                session.commit();
            }


        } catch (JMSException e) {
            e.printStackTrace();
        }finally {

            try {
                connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }

    }
}
