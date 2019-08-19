package com.yuliyao.activemq.consumer;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;

import javax.jms.*;

/**
 * 持久化订阅。即消费者故障重启后可以收到之前的消息
 * @author yuliyao
 * @date 2019/8/19
 */
public class PersistentTopicConsumer {

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = new ActiveMQConnectionFactory("tcp://localhost:61616").createConnection();
            connection.setClientID("YULIYAO-002");
            connection.start();
            final Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            ActiveMQTopic activeMQTopic = new ActiveMQTopic("firstTopic");
            TopicSubscriber durableSub = session.createDurableSubscriber(activeMQTopic, "YULIYAO-002");
            durableSub.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    try {
                        System.out.println(((TextMessage) message).getText());
                        if (((TextMessage) message).getText().equals("hello world!I am first topic8")) {
                            //确认消息，在这之前的消息不会被重发
                            session.commit();
                        }
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
                if (connection != null) {
                    connection.close();
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }

    }
}
