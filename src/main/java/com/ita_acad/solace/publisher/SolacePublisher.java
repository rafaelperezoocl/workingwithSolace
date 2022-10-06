package com.ita_acad.solace.publisher;
import com.solacesystems.jms.message.SolTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import javax.jms.JMSException;
@Component
public class SolacePublisher {

    @Autowired
    public JmsTemplate jmsTemplate;
    public void publishToGivenQueueName(String queueName, String messageText) throws JMSException {
        SolTextMessage message = new SolTextMessage();
        message.setText(messageText);
        jmsTemplate.convertAndSend(queueName, message);
    }

    public void publishToGivenTopicName(String topicName, String messageText) throws JMSException {
        SolTextMessage message = new SolTextMessage();
        message.setText(messageText);
        jmsTemplate.setPubSubDomain(true);
        jmsTemplate.convertAndSend(topicName, message);
    }
}