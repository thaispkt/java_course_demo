package com.cybersoft.cozastore03.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    // Tạo queue
    @Bean
    public Queue queue() {
        return new Queue("javaqueue03");
    }
    // Tạo queue thứ 2
//    public Queue queue1() {
//        return new Queue("javaqueue04");
//    }
    // Tạo exchange
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("exjava03");
    }
    // Tạo binding
    @Bean
    public Binding binding() {
        return BindingBuilder
                .bind(queue())
                .to(topicExchange())
                .with("/route03");
    }
}
