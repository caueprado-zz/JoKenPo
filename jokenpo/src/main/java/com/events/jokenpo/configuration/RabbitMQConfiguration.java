package com.events.jokenpo.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMQConfiguration {

    @Value("${jokenpo.game.queue}")
    private String queueName;

    @Value("${jokenpo.game.exchange}")
    private String gameExchange;

    @Value("${jokenpo.game.routingkey}")
    private String routingkey;

    @Value("${jokenpo.game.dlq-queue}")
    private String deadLetterQueue;

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("jokenpo.game.exchange");
    }

    @Bean
    public Queue queue() {
        return QueueBuilder
                .durable(queueName)
                .deadLetterExchange(gameExchange)
                .deadLetterRoutingKey(deadLetterQueue)
                .build();
    }

    @Bean
    public Queue dlq() {
        return QueueBuilder
                .durable(deadLetterQueue)
                .deadLetterExchange(gameExchange)
                .deadLetterRoutingKey(routingkey)
                .build();
    }

    @Bean
    public Binding binding(final Queue queue, final DirectExchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(queueName);
    }

    @Bean
    public Binding dlqBinding(final Queue dlq, final DirectExchange exchange) {
        return BindingBuilder
                .bind(dlq)
                .to(exchange)
                .with(deadLetterQueue);
    }

}
