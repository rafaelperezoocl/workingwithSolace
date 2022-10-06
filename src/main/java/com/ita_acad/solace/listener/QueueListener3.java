package com.ita_acad.solace.listener;
import com.solacesystems.jms.message.SolTextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import javax.jms.JMSException;
@Component
public class QueueListener3{

    private static final Logger logger = LoggerFactory.getLogger(QueueListener3.class);
    @JmsListener(destination = "PEREZRA/QUEUE_1", containerFactory = "defaultJmsListenerContainerFactory")
    public void onMessageReceived(SolTextMessage message) throws Exception{
        if(message.getText().contains("Hello World")) {
            logger.info("Message rece ived with Hello World");
        }
        logger.info("Message processed: "+ message.getText());
    }


}