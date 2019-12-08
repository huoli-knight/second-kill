package com.suixingpay.rabbitmq.config;

import com.suixingpay.rabbitmq.utils.MQSender;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {


    public static final String QUEUE = "queue1";
    public static final String REQUEST_QUEUE = "request_queue";
    public static final String EXCHANGE = "exchange";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE, true);
    }

    @Bean
    public Queue requestQueue() {
        return new Queue(REQUEST_QUEUE, true);
    }


    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(EXCHANGE);
    }


    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(exchange()).with("queue1");
    }

    @Bean
    public Binding binding0() {
        return BindingBuilder.bind(requestQueue()).to(exchange()).with("request_queue");
    }

}
