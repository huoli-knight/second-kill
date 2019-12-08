package com.suixingpay.rabbitmq.utils;

import com.suixingpay.rabbitmq.config.MQConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MQSender {

    private static final String REQUEST_QUEUE = "request_queue";

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendRequest(String id) {
        //log.info("sendRequest" + id);
        amqpTemplate.convertAndSend(MQConfig.EXCHANGE, REQUEST_QUEUE, id);
    }
}
