package com.example.orchestration.kafka;

import com.example.orchestration.model.Customer;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaCustomerProducer {

    private static final String TOPIC = "customer.created";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendCustomerCreated(Customer customer) {
        String message = new Gson().toJson(customer);
        kafkaTemplate.send(TOPIC, message);
        }
}
