package com.example.orchestration.repository;

import com.example.orchestration.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
    // You can define custom query methods here if needed
}