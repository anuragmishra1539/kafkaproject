package com.productsz.ProductsMicroservice.productservice;


import com.core.events.products.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class ProductService {
    private final Logger logger= LoggerFactory.getLogger(Product.class);
    @Autowired
    KafkaTemplate<String,Product> kafkaTemplate;

    public  String newProduct(Product product){
        String productId= UUID.randomUUID().toString();
        CompletableFuture<SendResult<String,Product>> future=
        kafkaTemplate.send("product-created-successfully",productId,product);
         future.whenComplete((result,exception)->{
             if (exception!=null){
                logger.error("************Failed to send message "+exception.getMessage());
             }else{
                logger.info("*************Message Sent Successfully"+result.getRecordMetadata());
             }
         });
       return "meri taraf se done h ";

    }
}
