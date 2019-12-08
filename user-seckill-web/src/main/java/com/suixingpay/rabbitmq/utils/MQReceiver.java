package com.suixingpay.rabbitmq.utils;

import com.suixingpay.rabbitmq.config.MQConfig;
import com.suixingpay.redis.controller.PanicBuyController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MQReceiver {

    @Autowired
    private PanicBuyController panicBuyController;

    @RabbitListener(queues = MQConfig.REQUEST_QUEUE)
    public void receiveRequest(String id) {
        panicBuyController.get(id);
        //todo  service
    }
}
