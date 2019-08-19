package com.yuliyao.activemq.consumer;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;

import javax.jms.*;

/**
 * @author yuliyao
 * @date 2019/8/19
 */
public class TopicConsumer {

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = new ActiveMQConnectionFactory("tcp://localhost:61616").createConnection();
            connection.start();
            Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            ActiveMQTopic activeMQTopic = new ActiveMQTopic("firstTopic");
            MessageConsumer consumer =
                    session.createConsumer(activeMQTopic);
            //此处使用receive会阻塞，另一种方式参数TopicConsumer2
            TextMessage receive = (TextMessage)consumer.receive();
            System.out.println(receive.getText());
            session.commit();
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
