package com.yuliyao.activemq.consumer;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;

import javax.jms.*;

/**
 * @author yuliyao
 * @date 2019/8/19
 */
public class TopicConsumer2 {

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = new ActiveMQConnectionFactory("tcp://localhost:61616").createConnection();
            connection.start();
            Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            ActiveMQTopic activeMQTopic = new ActiveMQTopic("firstTopic");
            MessageConsumer consumer =
                    session.createConsumer(activeMQTopic);
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {

                    try {
                        System.out.println(((TextMessage)message).getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });
            session.commit();
            while (true) {

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
