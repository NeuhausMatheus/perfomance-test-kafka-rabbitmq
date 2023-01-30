package com.matheusneuhaus.distributed.component.controller;

import com.matheusneuhaus.distributed.component.model.MessageItem;
import com.matheusneuhaus.distributed.component.service.KafkaProducerService;
import com.matheusneuhaus.distributed.component.service.RabbitMQProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Controller
public class WebController {

    private static final Logger LOG = LoggerFactory.getLogger(WebController.class);

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Autowired
    private RabbitMQProducerService rabbitMQProducerService;


    @RequestMapping(value = "/publish_kafka", method = RequestMethod.POST)
    public String sendMessageToKafkaConsumer(@RequestParam String message){
        MessageItem messageItem = new MessageItem();
        messageItem.setMessage(message);
        messageItem.setUuid(UUID.randomUUID().toString());
        messageItem.setTime(LocalDateTime.now().toString());

        LOG.info("New message: '{}'", messageItem);
        kafkaProducerService.send(messageItem);
        return "redirect:kafka_producer.html";
    }

    @RequestMapping(value = "/publish_rabbit", method = RequestMethod.POST)
    public String sendMessageToRabbitMQConsumer(@RequestParam String message){
        MessageItem messageItem = new MessageItem();
        messageItem.setMessage(message);
        messageItem.setUuid(UUID.randomUUID().toString());
        messageItem.setTime(LocalDateTime.now().toString());

        LOG.info("New message: '{}'", messageItem);
        rabbitMQProducerService.send(messageItem);
        return "redirect:rabbitmq_producer.html";
    }

    @RequestMapping(value = "/perf_rabbit", method = RequestMethod.POST)
    public String sendPerfToRabbitMQConsumer(@RequestParam int number_of_messages){
        MessageItem messageItem = new MessageItem();
        messageItem.setMessage("SendingAHugeMessageOnceThisIsAPerformanceTestMultipleHugeMessagesWillBeSentDoNotExpectToStopUntilNumberReached");
        messageItem.setUuid(UUID.randomUUID().toString());
        messageItem.setTime(LocalDateTime.now().toString());

        LOG.info("New message: '{}'", messageItem);
        for(int i = 0; i < number_of_messages; i++)
            rabbitMQProducerService.send(messageItem);
        return "redirect:rabbitmq_perf.html";
    }

    @RequestMapping(value = "/perf_kafka", method = RequestMethod.POST)
    public String sendPerfToKafkaConsumer(@RequestParam int number_of_messages){
        MessageItem messageItem = new MessageItem();
        messageItem.setMessage("SendingAHugeMessageOnceThisIsAPerformanceTestMultipleHugeMessagesWillBeSentDoNotExpectToStopUntilNumberReached");
        messageItem.setUuid(UUID.randomUUID().toString());
        messageItem.setTime(LocalDateTime.now().toString());

        LOG.info("New message: '{}'", messageItem);
        for(int i = 0; i < number_of_messages; i++)
            kafkaProducerService.send(messageItem);
        return "redirect:kafka_perf.html";
    }

}
