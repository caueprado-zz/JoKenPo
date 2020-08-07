package com.events.jokenpo.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GameActionListener {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = {"jokenpo.game.queue"})
    public void onMessage(final String message) {
        log.info("onMessage: {}", message);
        final String messageBody = new String(message);
        if (messageBody.length() > 4) throw new IllegalArgumentException();
        log.info("Consuming Message - " + messageBody);
        rabbitTemplate.receive();
    }

    public void player(final String message) {
        log.info("player x pc");
        final String messageBody = new String(message);
        if (messageBody.length() > 4) throw new IllegalArgumentException();
        log.info("Consuming Message - " + messageBody);
    }

}
