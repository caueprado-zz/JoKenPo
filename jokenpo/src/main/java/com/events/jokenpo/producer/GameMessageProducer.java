package com.events.jokenpo.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GameMessageProducer {

    private final RabbitTemplate rabbitTemplate;

    private final Queue queue;

    public void send(final String message) {
        MessageProperties messageProperties = new MessageProperties();
        Message message1 = new Message(message.getBytes(), messageProperties);
        rabbitTemplate.setExchange("jokenpo.game.exchange");
        rabbitTemplate.setRoutingKey("jokenpo.game.routingKey");
        rabbitTemplate.convertAndSend("jokenpo.game.queue", message1);
    }
}
