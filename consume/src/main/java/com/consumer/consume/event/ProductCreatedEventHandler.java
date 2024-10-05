package com.consumer.consume.event;

import com.core.events.products.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics = "product-created-successfully")
public class ProductCreatedEventHandler {

    private  final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @KafkaHandler
    public void handle(Product productCreatedEvent){
        LOGGER.info("Received the new Product"+ productCreatedEvent.getProductName());
    }
}