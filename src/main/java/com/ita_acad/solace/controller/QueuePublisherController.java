package com.ita_acad.solace.controller;
import com.ita_acad.solace.publisher.SolacePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.jms.JMSException;
@Controller
@RequestMapping("/queuePub")
public class QueuePublisherController {
    @Autowired
    private SolacePublisher solacePublisher;
    @PostMapping("/sendMessage")
    @ResponseBody
    public String sendMessageToQueue(@RequestBody String messageText) throws JMSException {
        solacePublisher.publishToGivenQueueName("OOCL/QUEUE_1",messageText);
        return "Success";
    }


    @PostMapping("/sendMessagetoNoel")
    @ResponseBody
    public String sendMessageToNoel(@RequestBody String messageText) throws JMSException {
        solacePublisher.publishToGivenQueueName("ROLLONO/QUEUE_1",messageText);
        return "Success";
    }



    @PostMapping("/consumer/subscriber")
    @ResponseBody
    public String sendMessageToQueue2(@RequestBody String messageText) throws JMSException {
        solacePublisher.publishToGivenQueueName("OOCL/TEAM_B/QUEUE_1",messageText);
        return "Success";
    }

    @PostMapping("/topic/sendMessage")
    @ResponseBody
    public String sendMessageToTopic(@RequestBody String messageText) throws JMSException {
        solacePublisher.publishToGivenTopicName("OOCL/TOPIC_1",messageText);
        return "Success sending to topic4";
    }



}

